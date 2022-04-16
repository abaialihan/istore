package com.marsh.iStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class IStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(IStoreApplication.class, args);
	}

}
