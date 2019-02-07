package com.springboot.tutorial.properties;

import com.springboot.tutorial.properties.bean.Any;
import com.springboot.tutorial.properties.bean.AnyHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    public final Logger logger = LoggerFactory.getLogger(PropertiesTest.class.getSimpleName());

    @Autowired
    private AnyHelper anyHelper;

    @Before
    public void propertiesTest() {
        Assert.assertNotNull(anyHelper);
    }

    @Test
    public void printProperties() {
        Any any = anyHelper.getAny();

        Assert.assertEquals("1", any.getCode());
        Assert.assertEquals("admin", any.getName());

        logger.info(any.toString());
    }
}
