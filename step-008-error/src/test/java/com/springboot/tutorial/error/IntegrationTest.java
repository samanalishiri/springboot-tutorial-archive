package com.springboot.tutorial.error;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ErrorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    public final Logger logger = LoggerFactory.getLogger(IntegrationTest.class.getSimpleName());

    @LocalServerPort
    private int port;

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
    public void indexController() {

        String url = "http://localhost:" + port + "/";

        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET,
                new HttpEntity<>(headers), String.class);

        Assert.assertEquals("RuntimeException", response.getBody());

        logger.info(String.format("request(/): %s", response.getBody()));
    }

}
