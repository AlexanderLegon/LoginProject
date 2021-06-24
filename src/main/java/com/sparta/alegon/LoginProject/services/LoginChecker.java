package com.sparta.alegon.LoginProject.services;


import com.sparta.alegon.LoginProject.repositories.LocalUser;
import com.sparta.alegon.LoginProject.entities.User;

import java.util.ArrayList;


public class LoginChecker {

    public int check(User user){
        return checkData( user);
    }

        public int checkData(User user) {
            ArrayList<User> toCheck = LocalUser.getUserList();
            for (int i = 0; i < toCheck.size(); i++) {
                if (user.getUsername().equals(toCheck.get(i).getUsername())) {
                    if (user.getPassword().equals(toCheck.get(i).getPassword())) {
                        if (toCheck.get(i).isAdmin()) {
                            return 4;
                        } else {
                            return 3;
                        }
                    } else {
                        return 2;
                    }
                } else if (i == toCheck.size() - 1) {
                    return 1;
                }
            }
            return 0;
        }
}




