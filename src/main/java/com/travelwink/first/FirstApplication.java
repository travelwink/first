package com.travelwink.first;

import com.travelwink.first.common.util.PrintApplicationInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author chris
 */
@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);
		PrintApplicationInfo.print(context);
	}

}
