package com.springboot.tutorial.webflux.web;

import com.springboot.tutorial.webflux.domain.User;
import com.springboot.tutorial.webflux.domain.UserEvent;
import com.springboot.tutorial.webflux.repository.UserRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import static com.springboot.tutorial.webflux.domain.UserEvent.createNow;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Stream.generate;
import static reactor.core.publisher.Flux.fromStream;
import static reactor.core.publisher.Flux.interval;
import static reactor.core.publisher.Flux.zip;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<User> create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<User> read(@PathVariable("id") final String id) {
        return userRepository.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<User> update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") final String id) {
        return userRepository.deleteById(id);
    }

    @RequestMapping(value = "/read/all", method = RequestMethod.GET)
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserEvent> sendPersonEvent(@PathVariable("id") final String id) {
        return userRepository.findById(id).flatMapMany(this::publish);
    }

    private Publisher<? extends UserEvent> publish(User user) {
        return zip(interval(ofSeconds(2)), fromStream(generate(() -> createNow(user)))).map(Tuple2::getT2);
    }

}
