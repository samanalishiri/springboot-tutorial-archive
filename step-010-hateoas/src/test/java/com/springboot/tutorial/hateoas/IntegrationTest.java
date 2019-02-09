package com.springboot.tutorial.hateoas;

import com.springboot.tutorial.hateoas.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HateoasApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest extends BaseTest {

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
    public void test001() {
        User user = User.create().setId(1L).setUsername("Sample-1").setPassword("User-1").setEmail("sampleuser1@gmail.com");

        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:"+port+"/user/save",
                HttpMethod.POST,
                entity,
                String.class);
    }

    @Test
    public void test002() throws IOException {

        String userId = "1";
        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:"+port+"/user/find/{id}",
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
