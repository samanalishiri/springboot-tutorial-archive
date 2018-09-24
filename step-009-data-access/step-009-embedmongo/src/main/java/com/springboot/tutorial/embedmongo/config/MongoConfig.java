package com.springboot.tutorial.embedmongo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
public class MongoConfig {

    public static final int PORT = 27017;
    private static final String HOST = "localhost";
    private static final String DATABASE_NAME = "step009";

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        MongoClient mongoClient = new MongoClient(HOST, PORT);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, DATABASE_NAME);
        return mongoTemplate;
    }
}