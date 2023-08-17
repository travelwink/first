package com.travelwink.first.geely.sddb.service.impl;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.travelwink.first.geely.sddb.service.NegativeResponseCodeService;
import com.travelwink.first.geely.sddb.service.OutputService;
import com.travelwink.first.geely.sddb.xmlNode.NegativeResponseCode;
import com.travelwink.first.geely.sddb.xmlNode.Project;
import com.travelwink.first.geely.sddb.xmlNode.System;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Service
public class OutputServiceImpl implements OutputService {

    @Autowired
    private NegativeResponseCodeService negativeResponseCodeService;

    @Override
    public void output(HttpServletResponse response) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        Project project = new Project();

        List<NegativeResponseCode> nrc = negativeResponseCodeService.list();

        System system = new System();
        system.setNegativeResponseCode(nrc);
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
}
