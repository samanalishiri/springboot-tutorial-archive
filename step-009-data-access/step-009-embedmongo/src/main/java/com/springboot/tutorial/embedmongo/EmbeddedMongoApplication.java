package com.springboot.tutorial.embedmongo;

import com.springboot.tutorial.embedmongo.domain.User;
import com.springboot.tutorial.embedmongo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.util.UUID;

import static com.springboot.tutorial.embedmongo.config.MongoConfig.MONGO_TEMPLATE;

@SpringBootApplication
public class EmbeddedMongoApplication {

    public final Logger logger = LoggerFactory.getLogger(EmbeddedMongoApplication.class.getSimpleName());

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedMongoApplication.class, args);
    }

    @Bean
    @DependsOn(MONGO_TEMPLATE)
    CommandLineRunner users(UserRepository repository) {

        User user = User.createEmpty()
                .setId(UUID.randomUUID().toString())
                .setUsername("Saman")
                .setPassword("Alishiri")
                .setEmail("samanalishiri@gmail.com");

        return args -> {
            repository.deleteAll();
            repository.save(user);
            repository.findAll().stream().forEach(e -> logger.info(e.toString()));
        };
    }
}
