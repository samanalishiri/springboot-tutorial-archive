package com.springboot.tutorial.hateoas.controller;

import com.springboot.tutorial.hateoas.BaseTest;
import com.springboot.tutorial.hateoas.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
public class UserRestTest extends BaseTest {

    public static final String FIND_BY_ID_URL = "http://localhost:8080/user/find/{id}";

    private TestRestTemplate testRestTemplate;

    private HttpHeaders headers;

    @Before
    public void setUp() {
        testRestTemplate = new TestRestTemplate(new RestTemplateBuilder());

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Stream.of(MediaType.APPLICATION_JSON).collect(Collectors.toList()));
    }

    @Test
    public void testGetUser() throws IOException {

        String userId = "1";
        ResponseEntity<String> response = testRestTemplate.exchange(
                FIND_BY_ID_URL,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class,
                userId);

        notNull(response);

        User user = getData(response, User.class);
        notNull(user);
        print(user);
    }

}
