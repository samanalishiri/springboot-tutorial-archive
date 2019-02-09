package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;

@org.springframework.stereotype.Repository
public class ModelRepositoryImpl implements Repository<String, Model> {

    private static final String KEY = "Model-5";

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, String, Model> commandHashOperations;
    private HashOperations<String, String, Map> queryHashOperations;

    @Autowired
    public ModelRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        commandHashOperations = redisTemplate.opsForHash();
        queryHashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Model m) {
        commandHashOperations.put(KEY, m.getId(), m);
    }

    @Override
    public Model findById(String id) {
        return Model.of(queryHashOperations.get(KEY, id));
    }

    @Override
    public Map<String, Model> findAll() {
        return null;
    }

    @Override
    public void update(Model m) {
        commandHashOperations.put(KEY, m.getId(), m);
    }

    @Override
    public void delete(String id) {
        commandHashOperations.delete(KEY, id);
    }

}