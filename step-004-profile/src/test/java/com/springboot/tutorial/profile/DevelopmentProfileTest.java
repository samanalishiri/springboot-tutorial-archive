package com.springboot.tutorial.profile;

import com.springboot.tutorial.profile.profile.ProfileName;
import com.springboot.tutorial.profile.service.AbstractService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = ProfileName.DEVELOPMENT)
public class DevelopmentProfileTest {

    public final Logger logger = LoggerFactory.getLogger(DevelopmentProfileTest.class.getSimpleName());

    @Autowired
    private AbstractService service;

    @Before
    public void contextLoads() {
        Assert.assertNotNull(service);
    }

    @Test
    public void developmentProfileTest() {
        Assert.assertEquals(ProfileName.DEVELOPMENT, service.getProfile());
        logger.info(String.format("Profile: %s", ProfileName.DEVELOPMENT));
    }

}
