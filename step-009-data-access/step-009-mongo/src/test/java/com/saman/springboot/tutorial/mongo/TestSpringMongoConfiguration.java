package com.saman.springboot.tutorial.mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.springboot.tutorial.mongo.repository")
@PropertySource("classpath:application.properties")
public class TestSpringMongoConfiguration {

	@Value("${spring.data.mongodb.host}")
	String host;

	@Value("${spring.data.mongodb.database}")
	String databaseName;

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(new MongoClient(host), databaseName);
	}
 
}