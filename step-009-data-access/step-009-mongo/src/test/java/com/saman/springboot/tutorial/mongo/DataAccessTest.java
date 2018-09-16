package com.saman.springboot.tutorial.mongo;

import com.springboot.tutorial.mongo.domain.User;
import com.springboot.tutorial.mongo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestSpringMongoConfiguration.class)
public class DataAccessTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void userRepository() {

        repository.deleteAll();

        Stream.of(User.create()
                .setId(UUID.randomUUID().toString())
                .setUsername("Saman")
                .setPassword("Alishiri")
                .setEmail("samanalishiri@gmail.com"))
                .forEach(repository::save);

        repository.findAll().stream().forEach(System.out::println);
    }

}
