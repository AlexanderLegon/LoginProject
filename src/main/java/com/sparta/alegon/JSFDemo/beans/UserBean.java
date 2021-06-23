package com.sparta.alegon.JSFDemo.beans;

import com.sparta.alegon.JSFDemo.entities.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped

public class UserBean {

    @Inject
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String addUser(){
        return "welcome";
    }
}
