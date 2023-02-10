package com.cybage.bankService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan(basePackages = "com.cybage")
//@ComponentScan(basePackages = "com.cybage.databaseConnection")
//@ComponentScan(basePackages = "com.cybage.model")
//@ComponentScan(basePackages = "com.cybage.service")

@SpringBootApplication(scanBasePackages = "com.cybage")
@EnableAutoConfiguration
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}

}
