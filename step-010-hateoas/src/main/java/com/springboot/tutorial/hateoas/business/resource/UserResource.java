package com.springboot.tutorial.hateoas.business.resource;

import com.springboot.tutorial.hateoas.controller.UserController;
import com.springboot.tutorial.hateoas.domain.User;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserResource extends ResourceSupport {
    private final User data;

    public UserResource(User data) {
        this.data = data;
        add(linkTo(UserController.class).withRel("data"));
        add(linkTo(methodOn(UserController.class).findById(data.getId())).withSelfRel());
    }

    public User getData() {
        return data;
    }

    public static UserResource create(User user){
        return new UserResource(user);
    }
}
