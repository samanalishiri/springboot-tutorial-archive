package com.springboot.tutorial.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("event : " + event);
    }
}
