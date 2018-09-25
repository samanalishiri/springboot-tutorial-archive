package com.springboot.tutorial.webflux.domain;

import java.util.Date;

public class UserEvent {

    private User user;

    private Date date;

    public static UserEvent createNow(User user) {
        return new UserEvent().setUser(user).setDate(new Date());
    }

    public User getUser() {
        return user;
    }

    public UserEvent setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public UserEvent setDate(Date date) {
        this.date = date;
        return this;
    }
}
