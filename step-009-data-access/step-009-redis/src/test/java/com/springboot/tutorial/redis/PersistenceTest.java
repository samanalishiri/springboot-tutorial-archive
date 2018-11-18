package com.springboot.tutorial.redis;

import com.springboot.tutorial.redis.business.ModelRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataRedisTest
@EnableAutoConfiguration
@ComponentScan(value = {"com.springboot.tutorial.redis.business",
        "com.springboot.tutorial.redis.config",
        "com.springboot.tutorial.redis.domain"})
public class PersistenceTest {

    @Autowired
    public ModelRepository repository;

    @Test
    public void _001save() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void _002read() {
    }

}
