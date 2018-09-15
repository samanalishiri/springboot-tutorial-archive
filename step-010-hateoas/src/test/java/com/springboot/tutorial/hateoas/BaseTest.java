package com.springboot.tutorial.hateoas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.tutorial.hateoas.controller.ResponseHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.io.IOException;

public abstract class BaseTest {
    protected void print(Object o) {
        System.out.println("Test: " + o.toString());
    }

    protected  <T> T getData(ResponseEntity<String> response, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseHolder responseHolder = objectMapper.readValue(response.getBody(), ResponseHolder.class);
        return clazz.cast(responseHolder.getData());
    }

    protected void notNull(Object o) {
        Assert.notNull(o, o.getClass().getSimpleName() + " is null");
    }
}
