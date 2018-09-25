package com.springboot.tutorial.webflux.utils;

import org.springframework.web.reactive.function.server.ServerRequest;

public final class ServletUtils {

    private ServletUtils() {
    }

    public static String getVariable(ServerRequest serverRequest, String id) {
        return serverRequest.pathVariable(id);
    }
}
