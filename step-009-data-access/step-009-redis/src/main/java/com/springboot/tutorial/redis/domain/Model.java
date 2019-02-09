package com.springboot.tutorial.redis.domain;

import java.io.Serializable;

public class Model implements Serializable {

    private String id;

    private String name;

    private String email;

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
