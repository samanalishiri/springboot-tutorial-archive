package com.springboot.tutorial.embedmongo.repository;

import com.springboot.tutorial.embedmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
