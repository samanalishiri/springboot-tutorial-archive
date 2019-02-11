package com.springboot.tutorial.step004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Step004Application {

    public static void main(String[] args) {
        SpringApplication.run(Step004Application.class, args);
    }
}
