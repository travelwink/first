package com.travelwink.first.geely.sddb.service.impl;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.travelwink.first.geely.sddb.service.*;
import com.travelwink.first.geely.sddb.xmlNode.*;
import com.travelwink.first.geely.sddb.xmlNode.System;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OutputServiceImpl implements OutputService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private NegativeResponseCodeService negativeResponseCodeService;

    @Autowired
    private EcuService ecuService;

    @Autowired
    private SwService swService;

    @Autowired
    private DiagServiceService diagServiceService;

    @Override
    public void output(HttpServletResponse response, String projectId) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        Project project = projectService.getXmlInfo(projectId);

        // System NRC
        System system = new System();
        List<NegativeResponseCode> nrc = negativeResponseCodeService.list();
        system.setNegativeResponseCode(nrc);


        // Tester start
        Tester tester = new Tester();
        List<TesterSessionLayerSession> layerSessionTesterSessionLayer = new ArrayList<>();
        TesterSessionLayerSession testerSessionLayerSession1 = new TesterSessionLayerSession();
        testerSessionLayerSession1.setId("01").setName("DefaultSession");
        TesterSessionLayerSession testerSessionLayerSession2 = new TesterSessionLayerSession();
        testerSessionLayerSession2.setId("02").setName("ProgrammingSession");
        TesterSessionLayerSession testerSessionLayerSession3 = new TesterSessionLayerSession();
        testerSessionLayerSession3.setId("03").setName("ExtendedSession");

        layerSessionTesterSessionLayer.add(testerSessionLayerSession1);
        layerSessionTesterSessionLayer.add(testerSessionLayerSession2);
        layerSessionTesterSessionLayer.add(testerSessionLayerSession3);
        tester.setTesterSessionLayerSession(layerSessionTesterSessionLayer);
        system.setTester(tester);
        // Tester end

        // Ecu start
        List<Ecu> ecus = ecuService.getRelatedList(projectId);
        ecus.forEach(ecu -> {
            List<Sw> sws = swService.getXmlInfo(ecu.getProjectEcuRelId());
            sws.forEach(sw -> {
                if ("APP".equals(sw.getType())) {
                    sw.setDTCStatusAvailabilityMask("FF");
                } else {
                    sw.setDTCStatusAvailabilityMask("00");
                }

                if (StringUtils.hasLength(sw.getTimingInitId())) {
                    sw.setStartupTime("");
                }

                TransmissionRate transmissionRate = new TransmissionRate();
                sw.setTransmissionRate(transmissionRate);

                initDataLinkLayers(sw);

                initTransportLayers(sw);

                initSessionLayers(sw);

                setServices(sw);

            });
            ecu.setSw(sws);
        });
        system.setEcu(ecus);
        // Ecu end

        project.setSystem(system);

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File destXmlTempFile = new File("static/colorFeatureTemplate.xml");

        response.setHeader("Content-Type", "text/xml");

//        FileUtils.writeStringToFile(destXmlTempFile, xmlMapper.writeValueAsString(project), "UTF-8");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            xmlMapper.writeValue(outputStream, project);

            outputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private void setServices(Sw sw) {
        List<DiagService> diagServices = diagServiceService.getServices(sw.getId());
        diagServices.forEach(service -> {
            // Set Service Connected NRC
            List<NegativeResponseCode> negativeResponseCodes = negativeResponseCodeService.getReleatedList(service.getId(), sw.getId());
            service.setNegativeResponseCodes(negativeResponseCodes);

            // Set SubFunction
            if ("10".equals(service.getId()) ||
                "11".equals(service.getId()) ||
                "19".equals(service.getId()) ||
                "27".equals(service.getId()) ||
                "2A".equals(service.getId()) ||
                "2C".equals(service.getId()) ||
                "3E".equals(service.getId()) ||
                "85".equals(service.getId())
            ) {
                getSubFunctions(sw.getId(), service.getId());
            }

            // Set Session (Diag Timing Init & Update timing parameter)


        });
        sw.setDiagServices(diagServices);
    }

    private void getSubFunctions(String diagId, String serviceCode) {

    }

    private static void initSessionLayers(Sw sw) {
        List<SessionLayerSession> sessionLayers = new ArrayList<>();
        if (sw.getBusName().contains("Ethernet")) {
            if ("APP".equals(sw.getType())) {
                createAppSessionLayerSessions(sessionLayers);
            } else {
                createOtherSessionLayerSessions(sessionLayers);
            }
        } else if (sw.getBusName().toUpperCase().contains("FLEXRAY")) {
            if ("APP".equals(sw.getType())) {
                createAppSessionLayerSessions(sessionLayers);
            } else {
                createOtherSessionLayerSessions(sessionLayers);
            }
        } else if (sw.getBusName().contains("CAN")) {
            if ("APP".equals(sw.getType())) {
                createAppSessionLayerSessions(sessionLayers);
            } else {
                createOtherSessionLayerSessions(sessionLayers);
            }
        } else if (sw.getBusName().contains("LIN")) {
            if ("APP".equals(sw.getType())) {
                createAppSessionLayerSessions(sessionLayers);
            } else {
                createOtherSessionLayerSessions(sessionLayers);
            }
        }
        sw.setSessionLayer(sessionLayers);
    }

    private static void createOtherSessionLayerSessions(List<SessionLayerSession> sessionLayers) {
        SessionLayerSession session2 = new SessionLayerSession();
        session2.setId("02")
                .setName("ProgrammingSession")
                .setP2ServerMax_default("25")
                .setDeltaP2Vehicle_multiframe("4970")
                .setMaxNumberOfDIDsForReadDID("1");
        sessionLayers.add(session2);
    }

    private static void createAppSessionLayerSessions(List<SessionLayerSession> sessionLayers) {
        SessionLayerSession session1 = new SessionLayerSession();
        session1.setId("01")
                .setName("DefaultSession")
                .setP2ServerMax_default("50")
                .setDeltaP2Vehicle_multiframe("13495")
                .setMaxNumberOfDIDsForReadDID("10");
        SessionLayerSession session3 = new SessionLayerSession();
        session3.setId("03")
                .setName("ExtendedSession")
                .setP2ServerMax_default("50")
                .setDeltaP2Vehicle_multiframe("13495")
                .setMaxNumberOfDIDsForReadDID("10");
        sessionLayers.add(session1);
        sessionLayers.add(session3);
    }

    private static void initTransportLayers(Sw sw) {
        List<TransportLayer> transportLayers = new ArrayList<>();
        if (sw.getBusName().contains("Ethernet")) {
            TransportLayer transportLayer = new TransportLayer();
            List<TransportLayerSession> sessions;
            transportLayer.setType("TCP_IP_ETH");
            if ("APP".equals(sw.getType())) {
                TransportLayerSession transportLayerSession1 = new TransportLayerSession();
                transportLayerSession1.setId("01")
                        .setName("DefaultSession")
                        .setADoIPDiagnosticMessageTimeout("2000");
                TransportLayerSession transportLayerSession3 = new TransportLayerSession();
                transportLayerSession3.setId("03")
                        .setName("ExtendedSession")
                        .setADoIPDiagnosticMessageTimeout("2000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession1);
                sessions.add(transportLayerSession3);
                transportLayer.setTransportLayerSessions(sessions);
            } else {
                TransportLayerSession transportLayerSession2 = new TransportLayerSession();
                transportLayerSession2.setId("02")
                        .setName("ProgrammingSession")
                        .setADoIPDiagnosticMessageTimeout("2000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession2);
                transportLayer.setTransportLayerSessions(sessions);
            }
        } else if (sw.getBusName().toUpperCase().contains("FLEXRAY")) {
            TransportLayer transportLayer = new TransportLayer();
            List<TransportLayerSession> sessions;
            transportLayer.setType("Flexray");
            if ("APP".equals(sw.getType())) {
                TransportLayerSession transportLayerSession1 = new TransportLayerSession();
                transportLayerSession1.setId("01")
                        .setName("DefaultSession")
                        .setFc2CfPerformance("20000")
                        .setCf2CfPerformance("10000")
                        .setCBrPerformance("255000")
                        .setCAsTimeout("1000")
                        .setCArTimeout("1000")
                        .setCBsTimeout("1000")
                        .setCCrTimeout("1000")
                        .setPduMaxLength("64000");
                TransportLayerSession transportLayerSession3 = new TransportLayerSession();
                transportLayerSession3.setId("03")
                        .setName("ExtendedSession")
                        .setFc2CfPerformance("20000")
                        .setCf2CfPerformance("10000")
                        .setCBrPerformance("255000")
                        .setCAsTimeout("1000")
                        .setCArTimeout("1000")
                        .setCBsTimeout("1000")
                        .setCCrTimeout("1000")
                        .setPduMaxLength("64000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession1);
                sessions.add(transportLayerSession3);
                transportLayer.setTransportLayerSessions(sessions);
            } else {
                TransportLayerSession transportLayerSession2 = new TransportLayerSession();
                transportLayerSession2.setId("02")
                        .setName("ProgrammingSession")
                        .setFc2CfPerformance("15000")
                        .setCf2CfPerformance("10000")
                        .setCBrPerformance("255000")
                        .setCAsTimeout("1000")
                        .setCArTimeout("1000")
                        .setCBsTimeout("1000")
                        .setCCrTimeout("1000")
                        .setPduMaxLength("64000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession2);
                transportLayer.setTransportLayerSessions(sessions);
            }
        } else if (sw.getBusName().contains("CAN")) {
            TransportLayer transportLayer = new TransportLayer();
            List<TransportLayerSession> sessions;
            transportLayer.setType("CAN");
            if ("APP".equals(sw.getType())) {
                TransportLayerSession transportLayerSession1 = new TransportLayerSession();
                transportLayerSession1.setId("01")
                        .setName("DefaultSession")
                        .setNCsPerformance("20000")
                        .setNBrPerformance("20000")
                        .setNAsTimeout("1000")
                        .setNArTimeout("1000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setPduMaxLength("64000");
                TransportLayerSession transportLayerSession3 = new TransportLayerSession();
                transportLayerSession3.setId("03")
                        .setName("ExtendedSession")
                        .setNCsPerformance("20000")
                        .setNBrPerformance("20000")
                        .setNAsTimeout("1000")
                        .setNArTimeout("1000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setPduMaxLength("64000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession1);
                sessions.add(transportLayerSession3);
                transportLayer.setTransportLayerSessions(sessions);
            } else {
                TransportLayerSession transportLayerSession2 = new TransportLayerSession();
                transportLayerSession2.setId("02")
                        .setName("ProgrammingSession")
                        .setNCsPerformance("100")
                        .setNBrPerformance("2000")
                        .setNAsTimeout("1000")
                        .setNArTimeout("1000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setPduMaxLength("64000");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession2);
                transportLayer.setTransportLayerSessions(sessions);
            }
        } else if (sw.getBusName().contains("LIN")) {
            TransportLayer transportLayer = new TransportLayer();
            List<TransportLayerSession> sessions;
            transportLayer.setType("LIN");
            if ("APP".equals(sw.getType())) {
                TransportLayerSession transportLayerSession1 = new TransportLayerSession();
                transportLayerSession1.setId("01")
                        .setName("DefaultSession")
                        .setNCsPerformance("900000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setSTMin("10");
                TransportLayerSession transportLayerSession3 = new TransportLayerSession();
                transportLayerSession3.setId("03")
                        .setName("ExtendedSession")
                        .setName("DefaultSession")
                        .setNCsPerformance("900000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setSTMin("10");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession1);
                sessions.add(transportLayerSession3);
                transportLayer.setTransportLayerSessions(sessions);
            } else {
                TransportLayerSession transportLayerSession2 = new TransportLayerSession();
                transportLayerSession2.setId("02")
                        .setName("ProgrammingSession")
                        .setNCsPerformance("900000")
                        .setNBsTimeout("1000")
                        .setNCrTimout("1000")
                        .setSTMin("10");
                sessions = new ArrayList<>();
                sessions.add(transportLayerSession2);
                transportLayer.setTransportLayerSessions(sessions);
            }
        }
        sw.setTransportLayer(transportLayers);
    }

    private static void initDataLinkLayers(Sw sw) {
        List<DataLinkLayer> dataLinkLayers = new ArrayList<>();
        if (sw.getBusName().toUpperCase().contains("FLEXRAY")) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("Flexray");
            dataLinkLayers.add(dataLinkLayer);
        } else if (sw.getBusName().contains("LIN")) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("LIN");
            dataLinkLayer.setLinVersion("21");
            dataLinkLayer.setBaudRate(String.valueOf(Math.round(Double.parseDouble(sw.getBusRate()))));
            dataLinkLayers.add(dataLinkLayer);
        } else if (sw.getBusName().contains("CAN")) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("CAN");
            dataLinkLayer.setAddressFormat(sw.getAddressFormat());
            dataLinkLayer.setBaudRate(String.valueOf(Math.round(Double.parseDouble(sw.getBusRate()))));
            dataLinkLayers.add(dataLinkLayer);
        }
        sw.setDataLinkLayer(dataLinkLayers);
    }
}
