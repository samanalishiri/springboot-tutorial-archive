package com.springboot.tutorial.redis;

import com.springboot.tutorial.redis.business.CrudRepository;
import com.springboot.tutorial.redis.domain.Model;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelRepositoryTest {

    public final Logger logger = LoggerFactory.getLogger(ModelRepositoryTest.class.getSimpleName());

    @Autowired
    public CrudRepository repository;

    @Before
    public void setUp() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void saveModelTest() {
        Model model = new Model();
        model.setId("1");
        model.setName("Saman Alishiri");
        model.setEmail("samanalishiri@gmail.com");
        repository.save(model);
    }

    @After
    public void tearDown() throws Exception {
        Model model = repository.findById("1");
        Assert.assertNotNull(model);

        logger.info(model.toString());
    }
}
