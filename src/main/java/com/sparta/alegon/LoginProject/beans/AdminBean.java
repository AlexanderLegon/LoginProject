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
    private String userStatus = "";
    private String removalStatusText="";

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getRemovalStatusText() {
        return removalStatusText;
    }

    public void setRemovalStatusText(String removalStatusText) {
        this.removalStatusText = removalStatusText;
    }

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
        if (!(user.getUsername() == null || user.getUsername().equals(""))) {
            if(!(user.getPassword() == null || user.getPassword().equals(""))) {
                if (LocalUser.checkUser(user)) {
                    userStatus = "This user already exists";
                } else {
                    LocalUser.addUser(user);
                    userStatus = "User created";
                }
            }else {userStatus = "cant create a user with a blank password";}
        } else {userStatus = "cant create a user with a blank username";}
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
        removalStatus = "user has been promoted to admin";
    }

    public void demoteAdmin() {
      LocalUser.changeAdminStatus(user,false);
        removalStatus = "user has been demoted from admin";
    }

    public ArrayList<String> getUserList(){
        return LocalUser.getUserListNames();
    }

    public String logout(){
       return "/view/LoginPage";
    }

    public void removeUserText() {
        int removeStatus = LocalUser.removeUser(user);
        switch (removeStatus){
            case 0:
                removalStatusText = "user is admin";
                break;
            case 1:
                removalStatusText ="user is gone";
                break;
        }
    }

    public void promoteAdminText() {
        LocalUser.changeAdminStatus(user,true);
        removalStatusText = "user has been promoted to admin";
    }

    public void demoteAdminText() {
        LocalUser.changeAdminStatus(user,false);
        removalStatusText = "user has been demoted from admin";
    }


}
