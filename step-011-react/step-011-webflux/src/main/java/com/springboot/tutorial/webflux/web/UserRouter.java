package com.springboot.tutorial.webflux.web;

import com.springboot.tutorial.webflux.domain.User;
import com.springboot.tutorial.webflux.domain.UserEvent;
import com.springboot.tutorial.webflux.repository.UserRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import static com.springboot.tutorial.webflux.domain.UserEvent.createNow;
import static com.springboot.tutorial.webflux.utils.ServletUtils.getVariable;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Stream.generate;
import static reactor.core.publisher.Flux.fromStream;
import static reactor.core.publisher.Flux.interval;
import static reactor.core.publisher.Flux.zip;

@Component
public class UserRouter {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userRepository.findAll(), User.class);
    }

    public Mono<ServerResponse> read(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userRepository.findById(getVariable(serverRequest, "id")), User.class);
    }

    public Mono<ServerResponse> sendPersonEvent(ServerRequest serverRequest) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userRepository.findById(getVariable(serverRequest, "id")).flatMapMany(this::publish), UserEvent.class);

    }

    private Publisher<? extends UserEvent> publish(User user) {
        return zip(interval(ofSeconds(2)), fromStream(generate(() -> createNow(user)))).map(Tuple2::getT2);
    }

}
