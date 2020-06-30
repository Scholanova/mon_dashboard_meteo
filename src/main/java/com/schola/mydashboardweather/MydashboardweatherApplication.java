package com.schola.mydashboardweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.schola")
public class MydashboardweatherApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MydashboardweatherApplication.class, args);
	}

}
