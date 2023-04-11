package com.travelwink.first.test;

import com.travelwink.first.common.api.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chris
 */
@RestController
@RequestMapping("/test")
public class PayloadController {
    @PostMapping
    public ApiResult test (@RequestBody Payload payload) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("payload", payload);
        ret.put("now", new Date());
        return ApiResult.ok(ret);
    }
}
