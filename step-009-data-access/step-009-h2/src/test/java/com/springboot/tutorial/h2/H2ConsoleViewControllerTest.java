package com.springboot.tutorial.h2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2ConsoleViewControllerTest {

    public final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class.getSimpleName());

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void indexView() throws Exception {
        ModelAndView modelAndView = mvc.perform(get("/")).andReturn().getModelAndView();
        Assert.assertEquals("forward:/h2-console", modelAndView.getViewName());

        logger.info(String.format("request(/): %s", modelAndView.getViewName()));

    }

}
