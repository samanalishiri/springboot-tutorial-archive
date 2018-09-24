package com.springboot.tutorial.reactivemongo.repository;

import com.springboot.tutorial.reactivemongo.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
