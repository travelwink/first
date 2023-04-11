package com.travelwink.first.common.util;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 打印项目信息
 *
 *
 * @author chris*/
@Slf4j
public class PrintApplicationInfo {

    /**
     * 执行之前，打印前置条件提示
     */
    public static void printTip(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        // 项目profile
        String profileActive = environment.getProperty("spring.profiles.active");
        StringBuffer tip = new StringBuffer();
        tip.append("===========================================================================================\n");
        tip.append("===========================================================================================\n");
        if ("dev".equals(profileActive)) {
            log.info("\n{}", Ansi.ansi().eraseScreen().fg(Ansi.Color.YELLOW).a(tip.toString()).reset().toString());
        }
    }

    /**
     * 启动成功之后，打印项目信息
     */
    public static void print(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        // 项目名称
        String projectFinalName = environment.getProperty("info.project-finalName");
        // 项目版本
        String projectVersion = environment.getProperty("info.project-version");
        // 项目profile
        String profileActive = environment.getProperty("spring.profiles.active");
        // 项目路径
        String contextPath = environment.getProperty("server.servlet.context-path");
        // 项目IP或域名地址
//        String serverIp = environment.getProperty("project-env.server-ip");
        String serverIp = "127.0.0.1";
        // 项目端口
        String port = environment.getProperty("server.port");
        // Spring Boot Admin Server地址，请先在admin模块中启动 SpringBootPlusAdminApplication
        String springBootAdminServerUrl = environment.getProperty("spring.boot.admin.client.url");

        log.info("projectFinalName : {}", projectFinalName);
        log.info("projectVersion : {}", projectVersion);
        log.info("profileActive : {}", profileActive);
        log.info("contextPath : {}", contextPath);
        log.info("serverIp : {}", serverIp);
        log.info("port : {}", port);

        String startSuccess = " ____    __                    __        ____                                                   \n" +
                "/\\  _`\\ /\\ \\__                /\\ \\__    /\\  _`\\                                                 \n" +
                "\\ \\,\\L\\_\\ \\ ,_\\    __     _ __\\ \\ ,_\\   \\ \\,\\L\\_\\  __  __    ___    ___     __    ____    ____  \n" +
                " \\/_\\__ \\\\ \\ \\/  /'__`\\  /\\`'__\\ \\ \\/    \\/_\\__ \\ /\\ \\/\\ \\  /'___\\ /'___\\ /'__`\\ /',__\\  /',__\\ \n" +
                "   /\\ \\L\\ \\ \\ \\_/\\ \\L\\.\\_\\ \\ \\/ \\ \\ \\_     /\\ \\L\\ \\ \\ \\_\\ \\/\\ \\__//\\ \\__//\\  __//\\__, `\\/\\__, `\\\n" +
                "   \\ `\\____\\ \\__\\ \\__/.\\_\\\\ \\_\\  \\ \\__\\    \\ `\\____\\ \\____/\\ \\____\\ \\____\\ \\____\\/\\____/\\/\\____/\n" +
                "    \\/_____/\\/__/\\/__/\\/_/ \\/_/   \\/__/     \\/_____/\\/___/  \\/____/\\/____/\\/____/\\/___/  \\/___/ \n" +
                "                                                                                                \n" +
                "                                                                                                ";

        String homeUrl = "http://" + serverIp + ":" + port + contextPath;
        String swaggerUrl = "http://" + serverIp + ":" + port + contextPath + "/swagger-ui.html";
        String knife4jUrl = "http://" + serverIp + ":" + port + contextPath + "/doc.html";
        log.info("Admin:   {}", springBootAdminServerUrl);
        log.info("Home:    {}", homeUrl);
        log.info("Knife4j: {}", knife4jUrl);
        log.info("Swagger: {}", swaggerUrl);
        log.info("spring-boot-plus project start success...........");
        if ("dev".equals(profileActive)) {
            log.info("\n{}", AnsiUtil.getAnsi(Ansi.Color.BLUE, startSuccess));
        } else {
            log.info("\n{}", startSuccess);
        }
    }

}
