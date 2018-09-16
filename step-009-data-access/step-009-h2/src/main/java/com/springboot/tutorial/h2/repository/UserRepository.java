package com.springboot.tutorial.h2.repository;

import com.springboot.tutorial.h2.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Saman Alishiri
 * @mail samanalishiri@gmail.com
 * @since yyyy-MM-dd
 */

public interface UserRepository extends CrudRepository<User, Long> {
}
