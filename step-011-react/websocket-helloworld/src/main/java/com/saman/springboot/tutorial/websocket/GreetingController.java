package com.saman.springboot.tutorial.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting hello(String message) throws Exception {
        return Greeting.builder().hello(message).build();
    }

    @MessageMapping("/bye")
    @SendTo("/topic/greetings")
    public Greeting bye(String message) throws Exception {
        return Greeting.builder().bye(message).build();
    }
}