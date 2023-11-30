package com.thetask.demo;

import java.util.ArrayList;

public class UserList {
    public static ArrayList<User> userList = new ArrayList<>();

    public void addUser(String username, String password) {
        userList.add(new User(username, password));
    }

    // public void addToDoListForUser(String username, ArrayList<ToDo> toDoList) {

    //     for (User user : userList) {
    //         if (user.getUsername() == username) {
    //             user.addToDoList(toDoList);
    //         }
    //     }
    // }

    public boolean checkUserNameExists(String username) {

        return false;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

}
