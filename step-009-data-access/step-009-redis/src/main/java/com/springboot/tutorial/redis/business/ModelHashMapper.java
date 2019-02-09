package com.springboot.tutorial.redis.business;

import com.springboot.tutorial.redis.domain.Model;
import org.springframework.data.redis.hash.HashMapper;

import java.util.HashMap;
import java.util.Map;

public class ModelHashMapper implements HashMapper<Model, String, Object> {

    @Override
    public Map<String, Object> toHash(Model object) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", object.getId());
        map.put("name", object.getName());
        map.put("email", object.getEmail());
        return map;
    }

    @Override
    public Model fromHash(Map<String, Object> hash) {
        Model model = new Model();
        model.setId(String.valueOf(hash.get("id")));
        model.setName(String.valueOf(hash.get("name")));
        model.setEmail(String.valueOf(hash.get("email")));

        return model;
    }
}