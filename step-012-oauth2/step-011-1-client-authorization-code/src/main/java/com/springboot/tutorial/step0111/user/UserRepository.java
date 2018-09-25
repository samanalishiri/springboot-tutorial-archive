package com.springboot.tutorial.step0111.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<ClientUser, Long> {
    Optional<ClientUser> findByUsername(String username);
}