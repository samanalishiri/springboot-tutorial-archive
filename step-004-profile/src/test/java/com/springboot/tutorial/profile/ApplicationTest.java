package com.springboot.tutorial.profile;

import com.springboot.tutorial.profile.profile.ProfileName;
import com.springboot.tutorial.profile.service.AbstractService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = ProfileName.DEVELOPMENT)
public class ApplicationTest {

    @Autowired
    private AbstractService service;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(service);
    }

}
