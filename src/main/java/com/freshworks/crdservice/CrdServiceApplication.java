package com.freshworks.crdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.freshworks.crdservice")
public class CrdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrdServiceApplication.class, args);
	}
}
