package com.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        new SpringApplication(ListenerApplication.class).run(args);
    }
}
