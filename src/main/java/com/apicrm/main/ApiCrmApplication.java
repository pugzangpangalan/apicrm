package com.apicrm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.apicrm")
public class ApiCrmApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiCrmApplication.class, args);
	}

}
