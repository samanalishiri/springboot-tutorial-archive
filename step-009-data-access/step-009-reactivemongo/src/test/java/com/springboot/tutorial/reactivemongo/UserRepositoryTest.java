package com.springboot.tutorial.reactivemongo;

import com.springboot.tutorial.reactivemongo.domain.User;
import com.springboot.tutorial.reactivemongo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestReactiveMongoConfiguration.class)
public class UserRepositoryTest {

    public final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class.getSimpleName());

    @Autowired
    private UserRepository repository;

    @Before
    public void truncate() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void userRepository() throws Exception {
        Mono<User> user = repository.save(User.createEmptyUser()
                .setId(UUID.randomUUID().toString())
                .setUsername("Saman")
                .setPassword("Alishiri")
                .setEmail("samanalishiri@gmail.com"));

        Assert.assertNotNull(user);
        logger.info(user.toFuture().get().toString());
    }

}
