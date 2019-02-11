package com.springboot.tutorial.step003.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String view() {
        return "hello";
    }

    @RequestMapping(value = "/echo", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<String> echo(@RequestParam("text") String text) {
        return ResponseEntity.ok().body(text);
    }
}

