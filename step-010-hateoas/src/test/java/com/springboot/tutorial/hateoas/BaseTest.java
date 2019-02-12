package com.springboot.tutorial.hateoas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.tutorial.hateoas.controller.ResponseHolder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public abstract class BaseTest {

    public final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    protected void log(Object o) {
        logger.info(String.format("%s", o.toString()));
    }

    protected  <T> T getData(ResponseEntity<String> response, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseHolder responseHolder = objectMapper.readValue(response.getBody(), ResponseHolder.class);
        return clazz.cast(responseHolder.getData());
    }

    protected void notNull(Object o) {
        Assert.assertNotNull(o);
    }
}
