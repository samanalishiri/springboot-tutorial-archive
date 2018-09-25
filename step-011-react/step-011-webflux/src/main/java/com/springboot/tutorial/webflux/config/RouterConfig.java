package com.springboot.tutorial.webflux.config;

import com.springboot.tutorial.webflux.web.UserRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<?> routerFunction(UserRouter userRouter) {
        return RouterFunctions.route(RequestPredicates.GET("/user/all"), userRouter::getAll)
                .andRoute(RequestPredicates.GET("/user/{id}"), userRouter::read)
                .andRoute(RequestPredicates.GET("/user/{id}/event"), userRouter::sendPersonEvent);
    }
}
