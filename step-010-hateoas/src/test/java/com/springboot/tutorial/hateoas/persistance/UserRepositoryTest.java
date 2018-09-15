package com.springboot.tutorial.hateoas.persistance;

import com.springboot.tutorial.hateoas.BaseTest;
import com.springboot.tutorial.hateoas.business.repository.UserRepository;
import com.springboot.tutorial.hateoas.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void save() {
        Stream.of(User.create().setId(1L).setUsername("Sample-1").setPassword("User-1").setEmail("sampleuser1@gmail.com"),
                User.create().setId(2L).setUsername("Sample-2").setPassword("User-2").setEmail("sampleuser2@gmail.com"))
                .forEach(repository::save);

        Optional<User> result = repository.findById(1L);
        User user = result.get();

        notNull(user);
        print(user);
    }

}
