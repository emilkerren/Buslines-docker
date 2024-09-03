package com.sl.buslines.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class BuslinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuslinesApplication.class, args);
	}

}
