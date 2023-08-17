package com.travelwink.first.geely.sddb.controller;

import com.travelwink.first.common.api.ApiResp;
import com.travelwink.first.geely.sddb.service.OutputService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sddb")
public class SddbController {

    @Autowired
    private OutputService outputService;

    @GetMapping("/output")
    public void output(HttpServletResponse response) throws Exception {
        outputService.output(response);
    }
}
