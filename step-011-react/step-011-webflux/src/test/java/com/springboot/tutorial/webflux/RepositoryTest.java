package com.springboot.tutorial.webflux;

import com.springboot.tutorial.webflux.domain.User;
import com.springboot.tutorial.webflux.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestReactiveMongoConfiguration.class)
public class RepositoryTest {

    @Autowired
    private UserRepository repository;

    @Before
    public void deleteAll() {
        repository.deleteAll();
    }

    @Test
    public void userRepository() {
        Mono<User> result = repository.save(User.create()
                .setId(UUID.randomUUID().toString())
                .setUsername("Saman")
                .setPassword("Alishiri")
                .setEmail("samanalishiri@gmail.com"));

        result.subscribe(Assert::assertNotNull);
    }

}
