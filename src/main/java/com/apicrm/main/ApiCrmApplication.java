package com.apicrm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.apicrm")
@EnableJpaRepositories(basePackages = "com.apicrm.repository")
@EntityScan(basePackages = "com.apicrm.entity")
public class ApiCrmApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiCrmApplication.class, args);
	}

}
