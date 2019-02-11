package com.springboot.tutorial.step005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Step005Application {

	public static void main(String[] args) {
		SpringApplication.run(Step005Application.class, args);
	}
}
