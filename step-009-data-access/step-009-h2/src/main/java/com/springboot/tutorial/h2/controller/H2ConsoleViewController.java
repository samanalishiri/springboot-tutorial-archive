package com.springboot.tutorial.h2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class H2ConsoleViewController {

    @GetMapping("/")
    public String viewH2Console() {
        return String.format("forward:%s", "/h2-console");
    }
}
