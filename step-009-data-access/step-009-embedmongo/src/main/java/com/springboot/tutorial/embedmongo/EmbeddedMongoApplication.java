package com.springboot.tutorial.embedmongo;

import com.springboot.tutorial.embedmongo.domain.User;
import com.springboot.tutorial.embedmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EmbeddedMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedMongoApplication.class, args);
    }

    @Bean
    @DependsOn("mongoTemplate")
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
