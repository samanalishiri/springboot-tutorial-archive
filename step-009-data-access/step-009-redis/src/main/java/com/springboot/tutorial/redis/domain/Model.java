package com.springboot.tutorial.redis.domain;

import java.io.Serializable;
import java.util.Map;

public class Model implements Serializable {

    private String id;

    private String name;

    private String email;

    public static Model of(Map<String, Object> map) {
        Model model = new Model();
        model.setId(String.valueOf(map.get("id")));
        model.setName(String.valueOf(map.get("name")));
        model.setEmail(String.valueOf(map.get("email")));

        return model;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" + "id:" + id + ", name:'" + name + '\'' + ", email:'" + email + '\'' + '}';
    }
}
