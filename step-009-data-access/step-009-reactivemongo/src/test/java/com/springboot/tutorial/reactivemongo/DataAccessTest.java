package com.springboot.tutorial.reactivemongo;

import com.springboot.tutorial.reactivemongo.domain.User;
import com.springboot.tutorial.reactivemongo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestReactiveMongoConfiguration.class)
public class DataAccessTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void userRepository() {
        Stream<User> users = Stream.of(
                User.create()
                        .setId(UUID.randomUUID().toString())
                        .setUsername("Saman")
                        .setPassword("Alishiri")
                        .setEmail("samanalishiri@gmail.com"),
                User.create()
                        .setId(UUID.randomUUID().toString())
                        .setUsername("Samira")
                        .setPassword("Talebi")
                        .setEmail("SamiraTalebi@gmail.com"));
        repository.deleteAll().subscribe(null, null,
                () -> users.forEach(user -> repository.save(user).subscribe(System.out::println)));
    }

}
