package com.travelwink.first.example.controller;

import com.travelwink.first.common.api.ApiResp;
import com.travelwink.first.example.entity.FormattedDateInfo;
import com.travelwink.first.example.service.FormatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/format")
public class InfoController {

    @Autowired
    private FormatService formatService;

    @GetMapping("/date")
    private ApiResp<FormattedDateInfo> getFormatDate(){
        return ApiResp.ok(formatService.getFormattedDate());
    }
}
