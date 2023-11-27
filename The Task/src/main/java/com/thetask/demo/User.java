package com.thetask.demo;

public class User {

    private static String existingUser = "existingUser"; //Hårdkodad för en användare som finns

    public static boolean checkIfUserExists(String username) { //usernamne är tänkt som det namn man skriver in i input fältet när man gör en ny användare
        if (username.equals(existingUser)) { //Kollar om username matchar med den befintliga användaren
            return false; //Returnerar false om det matchar
        } else {
            return true; //True om det inte matchar
        }
    }
}
