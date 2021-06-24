package com.sparta.alegon.LoginProject.beans;
import com.sparta.alegon.LoginProject.entities.User;
import com.sparta.alegon.LoginProject.entities.UsersEntity;
import com.sparta.alegon.LoginProject.repositories.LocalUser;
import com.sparta.alegon.LoginProject.services.LoginChecker;

import javax.enterprise.context.RequestScoped;
import javax.inject.*;
import java.util.ArrayList;


@Named
@RequestScoped

public class UserBean {

    @Inject
    private User user;

    private String loginError="";

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String validUser() {
        LoginChecker loginChecker = new LoginChecker();
        int temp = loginChecker.check(user);
        switch (temp) {
            case 1:
                loginError = "Username is incorrect";
                return "/view/LoginPage";
            case 2:
                loginError = "password is incorrect";
                return "/view/LoginPage";
            case 3:
                return "/view/welcome";
            case 4:
                return "/view/admin";
            default:
                return "/view/error";

        }

    }

    public String addUser() {
        LocalUser.addUser(user);
        return "LoginPage";
    }

    public void removeUser(User user) {
        LocalUser.removeUser(user);
    }

    public void promoteAdmin(User user) {
        user.setAdmin(true);
    }

    public void demoteAdmin(User user) {
        user.setAdmin(false);
    }

    public ArrayList<User> getUserList(){
        return LocalUser.getUserList();
    }
}

