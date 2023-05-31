package com.berkaygulen.akbankweatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AkbankWeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkbankWeatherAppApplication.class, args);
	}

}
