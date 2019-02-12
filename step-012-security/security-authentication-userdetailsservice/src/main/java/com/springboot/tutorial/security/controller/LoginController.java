package com.springboot.tutorial.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/security/login.view")
    public String login() {
        return "/security/login.html";
    }

    @RequestMapping(value = "/security/login.view?error")
    public String error() {
        return "forward:/security/login.view";
    }

}
