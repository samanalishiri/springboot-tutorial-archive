package com.springboot.tutorial.step005.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"com.springboot.tutorial"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

}
