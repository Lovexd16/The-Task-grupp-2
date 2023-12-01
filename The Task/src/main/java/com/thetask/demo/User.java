package com.thetask.demo;

import java.util.ArrayList;

public class User {


    private String username;
    private String password;
    private ArrayList<ListOfToDos> toDoLists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.toDoLists = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ListOfToDos> getToDoLists() {
        return toDoLists;
    }

    public void setToDoLists(ArrayList<ListOfToDos> toDoLists) {
        this.toDoLists = toDoLists;
    }

}
