package com.springboot.tutorial.properties.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertiesProcessor {

    @Autowired
    private AnyProperties anyProperties;

    public void print() {
        System.out.println(anyProperties.toString());
    }
}
