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

                TransportLayer transportLayer = new TransportLayer();
                transportLayer.setType(sw.getBusName());

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

    private static void initDataLinkLayers(Sw sw) {
        List<DataLinkLayer> dataLinkLayers;
        if ("Flexray".contains(sw.getBusName())) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("Flexray");
            dataLinkLayers = new ArrayList<>();
            dataLinkLayers.add(dataLinkLayer);
            sw.setDataLinkLayer(dataLinkLayers);
        } else if ("LIN".contains(sw.getBusName())) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("LIN");
            dataLinkLayer.setLinVersion("21");
            dataLinkLayer.setBaudRate("");
            dataLinkLayers = new ArrayList<>();
            dataLinkLayers.add(dataLinkLayer);
            sw.setDataLinkLayer(dataLinkLayers);
        } else if ("CAN".contains((sw.getBusName()))) {
            DataLinkLayer dataLinkLayer = new DataLinkLayer();
            dataLinkLayer.setType("CAN");
            dataLinkLayer.setAddressFormat(sw.getAddressFormat());
            dataLinkLayer.setBaudRate("");
            dataLinkLayers = new ArrayList<>();
            dataLinkLayers.add(dataLinkLayer);
            sw.setDataLinkLayer(dataLinkLayers);
        }
    }
}
