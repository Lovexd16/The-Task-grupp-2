package com.thetask.demo;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(String username, String password) {
        userList.add(new User(username, password, null));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    
}
