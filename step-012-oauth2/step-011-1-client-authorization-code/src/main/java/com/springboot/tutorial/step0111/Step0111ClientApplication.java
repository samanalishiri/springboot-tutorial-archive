package com.springboot.tutorial.step0111;

import com.springboot.tutorial.step0111.user.ClientUser;
import com.springboot.tutorial.step0111.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Step0111ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Step0111ClientApplication.class, args);
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
