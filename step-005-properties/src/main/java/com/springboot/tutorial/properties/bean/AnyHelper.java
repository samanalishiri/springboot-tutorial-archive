package com.springboot.tutorial.properties.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnyHelper {

    @Autowired
    private Any any;

    public Any getAny() {
        return any;
    }

}
