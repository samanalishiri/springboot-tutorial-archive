package com.saman.springboot.tutorial.mongo;

import com.springboot.tutorial.mongo.MongoDBApplication;
import com.springboot.tutorial.mongo.domain.User;
import com.springboot.tutorial.mongo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestSpringMongoConfiguration.class)
public class UserRepositoryTest {

    public final Logger logger = LoggerFactory.getLogger(MongoDBApplication.class.getSimpleName());

    @Autowired
    private UserRepository repository;

    @Before
    public void truncateUsers() {
        repository.deleteAll();
    }

    @Test
    public void userCrudTest() {
        User user = repository.save(User.createEmptyUser()
                .setId(UUID.randomUUID().toString())
                .setUsername("Saman")
                .setPassword("Alishiri")
                .setEmail("samanalishiri@gmail.com"));

        Assert.assertNotNull(user.getId());
        logger.info(user.toString());
    }
}
