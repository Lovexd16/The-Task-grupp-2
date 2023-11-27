package com.thetask.demo;


import java.util.List;

public class User {

    private List<String> existingUsernames; //Listan med användare

    public User(List<String> existingUsernames) { //Konstruktor som tar emot listan med användare. Används i Test
        this.existingUsernames = existingUsernames;
    }

    public boolean usernameInUse(String username) { //Returnerar true om användarnamnet redan finns, false om användarnamnet inte finns
        return existingUsernames.contains(username);
    }

    private String username;
    private String password;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
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


}
