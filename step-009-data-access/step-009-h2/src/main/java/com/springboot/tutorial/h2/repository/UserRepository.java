package com.springboot.tutorial.h2.repository;

import com.springboot.tutorial.h2.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
