package com.thetask.demo;

import java.util.ArrayList;

public class UserList {
    private  static ArrayList<User> userList = new ArrayList<>();


    public void addUser(String username, String password) {
        userList.add(new User(username, password));
    }

    public boolean checkUserNameExists(String username) {

        return false;
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

}
