package com.springboot.tutorial.listener;

import com.springboot.tutorial.listener.event.SampleEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    public ApplicationEventPublisher publisher;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(publisher);
    }

    @Test
    public void publishEvent() {
        publisher.publishEvent(new SampleEvent(this, "Test Event"));
    }

}
