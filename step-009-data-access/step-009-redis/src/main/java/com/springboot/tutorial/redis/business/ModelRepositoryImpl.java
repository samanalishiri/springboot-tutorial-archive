package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
 
@Repository
public class ModelRepositoryImpl implements ModelRepository {
 
	private static final String KEY = "Model";
 
	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Long, Model> hashOperations;
 
	@Autowired
	public ModelRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
 
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
 
	@Override
	public void save(Model customer) {
		hashOperations.put(KEY, customer.getId(), customer);
	}
 
	@Override
	public Model find(Long id) {
		return hashOperations.get(KEY, id);
	}
 
	@Override
	public Map<Long, Model> findAll() {
		return hashOperations.entries(KEY);
	}
 
	@Override
	public void update(Model customer) {
		hashOperations.put(KEY, customer.getId(), customer);
	}
 
	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
	}
 
}