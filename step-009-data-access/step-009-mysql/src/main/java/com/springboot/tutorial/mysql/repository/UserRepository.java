package com.springboot.tutorial.mysql.repository;

import com.springboot.tutorial.mysql.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
