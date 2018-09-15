package com.springboot.tutorial.listener;

import com.springboot.tutorial.listener.event.SampleEvent;
import org.springframework.context.ApplicationListener;

public class SampleEventListener implements ApplicationListener<SampleEvent> {

    @Override
    public void onApplicationEvent(SampleEvent event) {
        System.out.println("sample-event : " + event.getText());
    }
}
