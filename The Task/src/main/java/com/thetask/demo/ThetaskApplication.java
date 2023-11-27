package com.thetask.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);
	}

	public boolean checkForUser(String username, String password, ArrayList <User> users) {
		for (User item : users) {
			if (item.getUsername().equals(username) && item.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
