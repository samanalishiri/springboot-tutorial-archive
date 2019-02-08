package com.springboot.tutorial.embedmongo.config;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
public class MongoConfig {

    public static final String MONGO_TEMPLATE = "mongoTemplate";

    private static final String HOST = "localhost";
    private static final String DB_NAME = "step009";

    @Bean(MONGO_TEMPLATE)
    public MongoTemplate mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(HOST);
        MongoClient mongoClient = mongo.getObject();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, DB_NAME);
        return mongoTemplate;
    }

}