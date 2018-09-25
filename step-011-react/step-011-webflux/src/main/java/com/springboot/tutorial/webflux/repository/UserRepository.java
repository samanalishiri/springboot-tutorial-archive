package com.springboot.tutorial.webflux.repository;

import com.springboot.tutorial.webflux.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
