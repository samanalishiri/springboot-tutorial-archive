package com.springboot.tutorial.step004.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String root() {
        return "forward:/security/login.view";
    }

    @RequestMapping(value = "/home.view")
    public String home() {
        return "/home";
    }

}
