package com.travelwink.first;

import com.travelwink.first.common.util.PrintApplicationInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author chris
 */
@SpringBootApplication
@MapperScan({"com.travelwink.first.*.*.mapper"})
@EnableAsync
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);

//		ConfigurableApplicationContext context = new SpringApplicationBuilder()
//				.web(WebApplicationType.REACTIVE)
//				.sources(FirstApplication.class)
//				.run(args);

		PrintApplicationInfo.print(context);
	}

}
