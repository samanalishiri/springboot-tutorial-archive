package com.springboot.tutorial.client.repository;

import com.springboot.tutorial.client.domain.ClientUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<ClientUser, Long> {
    Optional<ClientUser> findByUsername(String username);
}