package com.springboot.tutorial.redis;

import com.springboot.tutorial.redis.business.ModelRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelRepositoryTest {

    @Autowired
    public ModelRepository repository;

    @Before
    public void setUp() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void saveModelTest() {
    }

}
