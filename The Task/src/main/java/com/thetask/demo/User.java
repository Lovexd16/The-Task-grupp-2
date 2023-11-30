package com.thetask.demo;

import java.util.ArrayList;

public class User {

    // private static List<String> existingUsernames; //Listan med användare

    // public User(List<String> existingUsernames) { //Konstruktor som tar emot
    // listan med användare. Används i Test
    // this.existingUsernames = existingUsernames;
    // }

    // public boolean usernameInUse(String username) { //Returnerar true om
    // användarnamnet redan finns, false om användarnamnet inte finns
    // return existingUsernames.contains(username);
    // }

    private String username;
    private String password;
    private ArrayList<ListOfToDos> toDoLists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.toDoLists = new ArrayList<>();

    }

    // public void addToDoList(ArrayList<ToDo> toDoList) {
    //     toDoLists.add(toDoList); // Stoppar in To Do-lista i användarens toDoLists

    // }

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
