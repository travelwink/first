package com.travelwink.first.example.controller;

import com.travelwink.first.common.api.ApiResp;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/escape")
@Tag(name = "Example - String escape")
public class StringEscapeController {

    @GetMapping("/input")
    public ApiResp<String> subscribeSse(@RequestParam("str") String str) throws IOException {
        log.info("Input str is: " + str);
        String result = StringEscapeUtils.unescapeHtml4(str);
        log.info("Result is: " + result);
        return ApiResp.ok(result);
    }
}
