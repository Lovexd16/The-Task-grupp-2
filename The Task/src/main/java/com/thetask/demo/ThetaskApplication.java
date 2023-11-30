package com.thetask.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);

		UserList.userList.add(new User("Kalle", "123"));
		UserList.userList.add(new User("Balle", "222"));

		addNewListForUser("Kalle", "Hushållssyssllur");
		addNewListForUser("Kalle", "Ärenden");

		addNewListForUser("Balle", "Shoppa");	
		addNewListForUser("Balle", "Träna");


		for (User user : UserList.userList) {
			if (user.getUsername().equals("Kalle")) {
				System.out.println("namnen på listor " + user.getToDoLists().get(0).getNameOfList() + " " + user.getToDoLists().get(1).getNameOfList());
			}
		}
		
		addNewToDoForUser("Kalle", "Ärenden", "Inget", 2);
		addNewToDoForUser("Balle", "Träna", "Axlar", 15);
		
		System.out.println("\n");

		System.out.println(UserList.userList.get(0).getToDoLists().get(0).getNameOfList());
		// ToDo stada = new ToDo("Städa", CurrentTime.getCurrentTime(), false);
		// ToDo tvatta = new ToDo("Tvätta", CurrentTime.getCurrentTime() - 5000, true);
		// ArrayList<ToDo> kallesToDoList = new ArrayList<>();
		// kallesToDoList.add(stada);
		// kallesToDoList.add(tvatta);

		// User lennart = new User("Lennart", "1234");
		// System.out.println("Lennarts storlek utan Kalle i sig " + lennart.toDoLists.size());
		// lennart.addToDoList(kallesToDoList);

		// System.out.println("Lennarts storlek med Kalle i sig " + lennart.toDoLists.size());
		// System.out.println(lennart.getToDoLists().get(0).get(0).getName());

		// System.out.println("Städa tid: " + stada.getTime());
		// System.out.println("Städa namn: " + stada.getName());
		// System.out.println("Tvätta tid: " + tvatta.getTime());

	}

	public static void addNewListForUser(String username, String nameOfList) {
		for (User user : UserList.userList) {
			if (user.getUsername().equals(username)) {
				user.getToDoLists().add((new ListOfToDos(null, nameOfList)));
			}
		}
	}	

	public static void addNewToDoForUser (String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
		for (User user : UserList.userList) {
			if (user.getUsername().equals(username)) {
				System.out.println(user.getUsername());
				for (ListOfToDos list : user.getToDoLists()) {
					System.out.println(list.getNameOfList());
					if (list.getNameOfList().equals(nameOfList)) {
						user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDos().add(new ToDo(nameOfToDo, timeOfToDo, false));
						System.out.println(list.getListOfToDos().get(0).getName());
					}
				}
			}
		}
	}
}
