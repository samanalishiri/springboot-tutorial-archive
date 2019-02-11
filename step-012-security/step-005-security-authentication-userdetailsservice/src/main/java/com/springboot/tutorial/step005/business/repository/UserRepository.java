package com.springboot.tutorial.step005.business.repository;


import com.springboot.tutorial.step005.domain.UserEntity;

public interface UserRepository extends SpringDataJpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
