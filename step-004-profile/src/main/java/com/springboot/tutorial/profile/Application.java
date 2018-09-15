package com.springboot.tutorial.profile;

import com.springboot.tutorial.profile.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AbstractService service;

    public void run(String... args) {
        service.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
