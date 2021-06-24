package com.sparta.alegon.LoginProject.beans;
import com.sparta.alegon.LoginProject.entities.User;
import com.sparta.alegon.LoginProject.repositories.LocalUser;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Named
@RequestScoped
public class AdminBean {

    @Inject
    private User user;

    private String removalStatus="";


    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public String getRemovalStatus() {
        return removalStatus;
    }

    public void setRemovalStatus(String removalStatus) {
        this.removalStatus = removalStatus;
    }

    public void addUser() {
        LocalUser.addUser(user);
    }

    public void removeUser() {
        int removeStatus = LocalUser.removeUser(user);
        switch (removeStatus){
            case 0:
                removalStatus = "user is admin";
                    break;
            case 1:
                removalStatus ="user is gone";
                    break;
        }
    }

    public void promoteAdmin() {
        LocalUser.changeAdminStatus(user,true);
    }

    public void demoteAdmin() {
      LocalUser.changeAdminStatus(user,false);
    }

    public ArrayList<String> getUserList(){
        return LocalUser.getUserListNames();
    }
}
