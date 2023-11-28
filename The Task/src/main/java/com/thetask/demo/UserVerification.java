package com.thetask.demo;

import java.util.ArrayList;

public class UserVerification {
    
    	public static boolean checkForUser(String username, String password, ArrayList <User> users) {
		for (User item : users) {
			if (item.getUsername().equals(username) && item.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
