package com.springboot.tutorial.hateoas.controller;

import com.springboot.tutorial.hateoas.business.repository.UserRepository;
import com.springboot.tutorial.hateoas.business.resource.UserResource;
import com.springboot.tutorial.hateoas.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ExposesResourceFor(User.class)
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/find/{id}", method = {RequestMethod.GET})
    public ResponseEntity<UserResource> findById(@PathVariable final long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(new UserResource(user)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public ResponseEntity<UserResource> save(@RequestBody final User userFromRequest) {
        final User user = userRepository.save(userFromRequest);
        return ResponseEntity.created(MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri())
                .body(UserResource.create(user));
    }

    @RequestMapping("/edit")
    public ResponseEntity<UserResource> edit(@RequestBody final User user) {
        userRepository.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri())
                .body(UserResource.create(user));
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<?> delete(@PathVariable("id") final long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("success");
    }
}
