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

    public String validUser() {
        LoginChecker loginChecker = new LoginChecker();
        int temp = loginChecker.check(user.getName(), user.getPassword());
        if (temp == 1) {
            return "welcome";
        }
        if (temp == 2) {
            return "potato";
        }
        if (temp == 3) {
            return "potato";
        }
        return "potato";
    }
}

