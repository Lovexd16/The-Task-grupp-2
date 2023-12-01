package com.thetask.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static UserList userlist = new UserList();

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);

		

		userlist.getUserList().add(new User("Kalle", "123"));
		userlist.getUserList().add(new User("Balle", "222"));


		System.out.println(userlist.getUserList().get(0).getUsername());
		
		addNewListForUser("Kalle", "Hushållssyssllur");
		addNewListForUser("Kalle", "Ärenden");

		addNewListForUser("Balle", "Shoppa");	
		addNewListForUser("Balle", "Träna");


		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals("Kalle")) {
				System.out.println("namnen på Kalles listor " + user.getToDoLists().get(0).getNameOfList() + " " + user.getToDoLists().get(1).getNameOfList());
			}
		}
		
		addNewToDoForUser("Kalle", "Ärenden", "Inget", 2);
		addNewToDoForUser("Balle", "Träna", "Axlar", 15);
		

		System.out.println(userlist.getUserList().get(0).getToDoLists().get(1).getListOfToDos().get(0).getName());
		
	}

	public static void addNewListForUser(String username, String nameOfList) {
		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals(username)) {
				user.getToDoLists().add((new ListOfToDos(null, nameOfList)));
			}
		}
	}	

	public static void addNewToDoForUser (String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals(username)) {
				for (ListOfToDos list : user.getToDoLists()) {
					if (list.getNameOfList().equals(nameOfList)) {
						user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDos().add(new ToDo(nameOfToDo, timeOfToDo, false));
					}
				}
			}
		}
	}
}
