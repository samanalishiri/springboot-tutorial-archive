package com.springboot.tutorial.properties;

import com.springboot.tutorial.properties.bean.PropertiesProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private PropertiesProcessor processor;

    @Before
    public void propertiesTest() {
        Assert.assertNotNull(processor);
    }

    @Test
    public void printProperties() {
        processor.print();
    }
}
