package com.springboot.tutorial.event;

import org.springframework.context.ApplicationEvent;

public class SampleEvent extends ApplicationEvent {

    private String text;

    public SampleEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
