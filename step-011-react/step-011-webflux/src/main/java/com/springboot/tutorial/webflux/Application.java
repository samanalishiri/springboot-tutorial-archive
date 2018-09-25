package com.springboot.tutorial.webflux;

import com.springboot.tutorial.webflux.domain.User;
import com.springboot.tutorial.webflux.repository.UserRepository;
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
        return args ->
                repository.deleteAll()
                        .subscribe(null, null, () ->
                                Stream.of(
                                        User.create()
                                                .setId(UUID.randomUUID().toString())
                                                .setUsername("Saman")
                                                .setPassword("Alishiri")
                                                .setEmail("samanalishiri@gmail.com"),
                                        User.create()
                                                .setId(UUID.randomUUID().toString())
                                                .setUsername("Samira")
                                                .setPassword("Talebi")
                                                .setEmail("SamiraTalebi@gmail.com"))
                                        .forEach(user -> repository.save(user).subscribe(System.out::println)));

    }

}
