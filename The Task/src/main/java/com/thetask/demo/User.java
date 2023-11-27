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

}
