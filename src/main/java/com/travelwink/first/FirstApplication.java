package com.travelwink.first;

import com.travelwink.first.common.util.PrintApplicationInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author chris
 */
@SpringBootApplication
@MapperScan({"com.travelwink.first.*.*.mapper"})
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);
		PrintApplicationInfo.print(context);
	}

}
