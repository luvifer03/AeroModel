package com.cognizant.ams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AirportManagementSystemApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApplication.class);
	}

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(AirportManagementSystemApplication.class);
		SpringApplication.run(AirportManagementSystemApplication.class, args);
		
	}

}
