package com.springboot.tutorial.client;

import com.springboot.tutorial.client.domain.ClientUser;
import com.springboot.tutorial.client.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner users(UserRepository repository) {
        return args -> {
            ClientUser user = new ClientUser();
            user.setUsername("user");
            user.setPassword("user");
            repository.save(user);

        };

    }
}
