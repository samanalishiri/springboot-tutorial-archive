package com.springboot.tutorial.h2;

import com.springboot.tutorial.h2.domain.User;
import com.springboot.tutorial.h2.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {

    public final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class.getSimpleName());

    @Autowired
    private UserRepository repository;

    @Test
    public void saveUserTest() {
        User user = repository.save(User.createEmptyUser()
                .setId(1L)
                .setUsername("Sample-1")
                .setPassword("User-1")
                .setEmail("sampleuser1@gmail.com"));

        Assert.assertNotNull("user is null", user);
        logger.info(String.format("%s", user.toString()));
    }

}
