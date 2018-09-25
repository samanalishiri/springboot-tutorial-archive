package com.springboot.tutorial.client.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;

public class ClientAuthorizationCodeApplication implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.getSessionCookieConfig().setName("client-session");
    }
}
