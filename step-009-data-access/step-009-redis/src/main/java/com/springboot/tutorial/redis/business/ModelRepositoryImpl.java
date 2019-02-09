package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ModelRepositoryImpl implements CrudRepository<String, Model> {

    private static final String KEY = "Model";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Map> hashOperations;

    private HashMapper<Model, String, Object> mapper = new ModelHashMapper();

    @Override
    public void save(Model m) {
        hashOperations.put(KEY, m.getId(), mapper.toHash(m));
    }

    @Override
    public Model findById(String id) {
        return mapper.fromHash(hashOperations.get(KEY, id));
    }

    @Override
    public Map<String, Model> findAll() {
        return hashOperations.entries(KEY).entrySet().stream()
                .map(e -> new HashMap.SimpleEntry<String, Model>(e.getKey(), mapper.fromHash(e.getValue())))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }

    @Override
    public void update(Model m) {
        hashOperations.put(KEY, m.getId(), mapper.toHash(m));
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }

}