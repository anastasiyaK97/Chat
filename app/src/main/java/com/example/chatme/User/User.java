package com.example.chatme.User;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String login;
    private String password;
    public  static List<User> users;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public static User getFirstUser(){
        return users.get(0);
    }

    public static void addUserInList(User u){
        users.add(u);
    }
}
