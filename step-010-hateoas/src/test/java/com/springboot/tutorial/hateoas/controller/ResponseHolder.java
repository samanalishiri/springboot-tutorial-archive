package com.springboot.tutorial.hateoas.controller;

import com.springboot.tutorial.hateoas.domain.User;

public class ResponseHolder {

    User data = new User();
    Object _links = new Object();

    public ResponseHolder() {
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
