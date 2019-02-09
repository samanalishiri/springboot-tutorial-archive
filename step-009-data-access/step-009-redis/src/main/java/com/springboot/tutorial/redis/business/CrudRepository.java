package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;

import java.util.Map;

public interface CrudRepository<ID, M> {

    void save(M m);

    Model findById(ID id);

    Map<String, M> findAll();

    void update(M m);

    void delete(ID id);
}