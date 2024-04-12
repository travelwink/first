package com.travelwink.first.common.controller.exception;

import com.travelwink.first.common.api.ApiCode;
import com.travelwink.first.common.api.ApiResp;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局Error/404处理
 * @author chris
 */
@RestController
@Slf4j
@Tag(name = "Global Error Controller")
public class GlobalErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public ApiResp handleError(HttpServletRequest request, HttpServletResponse response){
        int status = response.getStatus();
        switch (status){
            case HttpServletResponse.SC_UNAUTHORIZED:
                return ApiResp.fail(ApiCode.UNAUTHORIZED);
            case HttpServletResponse.SC_FORBIDDEN:
                return ApiResp.fail(ApiCode.NOT_PERMISSION);
            case HttpServletResponse.SC_NOT_FOUND:
                return ApiResp.fail(ApiCode.NOT_FOUND);
            default:
                break;
        }
        return ApiResp.fail(ApiCode.FAIL);
    }

}
