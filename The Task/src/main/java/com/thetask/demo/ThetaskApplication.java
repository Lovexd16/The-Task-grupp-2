package com.thetask.demo;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {


	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);
		
	}

	public static void addNewListForUser(String username, String nameOfList) {
		for (User user : UserList.getUserList()) {
			if (user.getUsername().equals(username)) {
				user.getToDoLists().add((new ListOfToDos(null, nameOfList)));
			}
		}
	}

	public static void removeListForUser(String username, String nameOfList) {
		for (User user : UserList.getUserList()) {
			if (user.getUsername().equals(username)) {
				ArrayList<ListOfToDos> toDoLists = user.getToDoLists();
				ListOfToDos listToRemove = null;

				for (ListOfToDos findListToRemove : toDoLists) {
					if (findListToRemove.getNameOfList().equals(nameOfList)) {
						listToRemove = findListToRemove;
					}
				}

				if (listToRemove != null) {
					toDoLists.remove(listToRemove);
				}
			}
		}
	}

	public static void clearListForUser(String username, String nameOfList) {
		for (User user : UserList.getUserList()) {
			if (user.getUsername().equals(username)) {
				for (ListOfToDos listToClear : user.getToDoLists()) {
					if (listToClear.getNameOfList().equals(nameOfList)) {
						listToClear.getListOfToDo().clear();
					}
				}
			}
		}
	}
}