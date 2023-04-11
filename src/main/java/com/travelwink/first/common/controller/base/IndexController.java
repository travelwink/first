package com.travelwink.first.common.controller.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 项目根路径提示信息
 * </p>
 *
 * @author chris
 * @since 2022/07/21
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    /**
     * SwaggerUI
     */
    @GetMapping("/docs")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }

}
