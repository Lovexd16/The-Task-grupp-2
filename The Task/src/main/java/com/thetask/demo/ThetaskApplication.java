package com.thetask.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);

		User user = new User("username", "password", null);
		System.out.println(user.getUsername());
		
		user.setListOfLists(new ArrayList<ListOfToDos>());

		System.out.println(user.getListOfLists());
	}

}



	

