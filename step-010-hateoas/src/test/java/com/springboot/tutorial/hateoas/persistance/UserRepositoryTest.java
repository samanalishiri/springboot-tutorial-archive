package com.springboot.tutorial.hateoas.persistance;

import com.springboot.tutorial.hateoas.BaseTest;
import com.springboot.tutorial.hateoas.business.repository.UserRepository;
import com.springboot.tutorial.hateoas.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void save() {
        repository.save(User.create()
                .setId(1L)
                .setUsername("samanalishiri")
                .setPassword("password")
                .setEmail("samanalishiri@gmail.como"));

        Optional<User> result = repository.findById(1L);
        result.ifPresent(Assert::assertNotNull);
        log(result.get());
    }

}
