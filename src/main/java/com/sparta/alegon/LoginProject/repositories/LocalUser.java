package com.sparta.alegon.LoginProject.repositories;

import com.sparta.alegon.LoginProject.entities.User;

import java.util.ArrayList;
import java.util.Arrays;

public class LocalUser {

   private static ArrayList<User> userList = new ArrayList<>(Arrays.asList(
           new User("4ply", "paper", true),
           new User("1ply", "paper", false),
           new User("MRmeme", "paper", false)));

   public static void addUser(User user) {
      userList.add(user);
   }

   public static ArrayList getUserList() {
      return userList;
   }

   public static int removeUser(User user) {

      for (int i = 0; i < userList.size(); i++) {
         if (userList.get(i).getUsername().equals(user.getUsername())) {
            if(!userList.get(i).isAdmin()) {
               userList.remove(i);
               return 1;
            }
            break;
         }
      }
      return 0;
   }

   public static void changeAdminStatus(User user, boolean status) {
      for (int i = 0; i < userList.size(); i++) {
         if (userList.get(i).getUsername().equals(user.getUsername())) {
            userList.get(i).setAdmin(status);
            break;
         }
      }
   }

   public static ArrayList<String> getUserListNames(){
   ArrayList<String> tempNames = new ArrayList<>();
      for(User user : userList)
      {
         tempNames.add(user.getUsername());
      }
      return tempNames;
   }
}




