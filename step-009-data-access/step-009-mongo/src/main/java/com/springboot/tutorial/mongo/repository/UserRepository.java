package com.springboot.tutorial.mongo.repository;

import com.springboot.tutorial.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
