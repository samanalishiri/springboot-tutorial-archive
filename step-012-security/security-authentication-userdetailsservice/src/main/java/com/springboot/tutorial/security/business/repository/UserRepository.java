package com.springboot.tutorial.security.business.repository;


import com.springboot.tutorial.security.domain.UserEntity;

public interface UserRepository extends SpringDataJpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
