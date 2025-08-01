package com.cdacproject.stayfinder.pg_property_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cdacproject.stayfinder.pg_property_service")
@EnableJpaRepositories(basePackages = "com.cdacproject.stayfinder.pg_property_service.repository")
@EntityScan(basePackages = "com.cdacproject.stayfinder.pg_property_service.model")
public class PgPropertyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgPropertyServiceApplication.class, args);
	}

}
