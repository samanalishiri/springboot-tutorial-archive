package com.springboot.tutorial.args.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeforeStart implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("before start : args = " + Arrays.toString(args));
    }
}
