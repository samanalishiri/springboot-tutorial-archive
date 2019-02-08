package com.springboot.tutorial.args.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class OptionalArguments {

    @Autowired
    public OptionalArguments(ApplicationArguments args) {
        System.out.println("args = " + Arrays.toString(args.getOptionNames().toArray()));
    }
}
