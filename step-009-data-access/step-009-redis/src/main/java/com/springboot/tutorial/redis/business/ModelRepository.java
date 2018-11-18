package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;

import java.util.Map;

public interface ModelRepository {
 
	void save(Model customer);
    Model find(Long id);
	Map<Long, Model> findAll();
	void update(Model customer);
	void delete(Long id);
}