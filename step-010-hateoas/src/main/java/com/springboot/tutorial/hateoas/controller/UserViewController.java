package com.springboot.tutorial.hateoas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserViewController {

    @RequestMapping(value = "/")
    public String view(){
        return "user";
    }
}
