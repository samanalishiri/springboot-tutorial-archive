package com.springboot.tutorial.hateoas.business.repository;

import com.springboot.tutorial.hateoas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
