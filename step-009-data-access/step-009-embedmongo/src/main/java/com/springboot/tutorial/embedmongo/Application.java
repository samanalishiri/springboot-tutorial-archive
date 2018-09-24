package com.springboot.tutorial.embedmongo;

import com.springboot.tutorial.embedmongo.domain.User;
import com.springboot.tutorial.embedmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner users(UserRepository repository) {
        return args -> {

            repository.deleteAll();
            Stream.of(User.create()
                    .setId(UUID.randomUUID().toString())
                    .setUsername("Saman")
                    .setPassword("Alishiri")
                    .setEmail("samanalishiri@gmail.com"))
                    .forEach(repository::save);

            repository.findAll().stream().forEach(System.out::println);

        };
    }
}
