package com.thetask.demo;

import java.util.ArrayList;
import java.util.UUID;

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
				System.out.println("namnen på Kalles listor " + user.getToDoLists().get(0).getNameOfList() + " "
						+ user.getToDoLists().get(1).getNameOfList());
			}
		}

		addNewToDoForUser("Kalle", "Ärenden", "Inget", 2);
		addNewToDoForUser("Balle", "Träna", "Axlar", 15);
		System.out.println(userlist.getUserList().get(1).getToDoLists().get(1).getListOfToDo().get(0).getName());

		addNewToDoForUser("Balle", "Träna", "Ben", 15);
		System.out.println("Balles innehåll i listan innan borttagning av axlar i listan träna");
		for (User user : ThetaskApplication.userlist.getUserList()) {
			if (user.getUsername().equals("Balle")) {
				for (ListOfToDos list : user.getToDoLists()) {
					if (list.getNameOfList().equals("Träna")) {
						for (ToDo todo : list.getListOfToDo()) {
							System.out.println(todo.getName());
						}
					}
				}
			}
		}

		ListOfToDos.removeToDo("Balle", "Träna", "Axlar", 1);

		System.out.println("Balles innehåll i listan efter borttagning av axlar i listan träna");
		for (User user : ThetaskApplication.userlist.getUserList()) {
			if (user.getUsername().equals("Balle")) {
				for (ListOfToDos list : user.getToDoLists()) {
					if (list.getNameOfList().equals("Träna")) {
						for (ToDo todo : list.getListOfToDo()) {
							System.out.println(todo.getName());
						}
					}
				}
			}
		}

		System.out.println(userlist.getUserList().get(0).getToDoLists().get(1).getListOfToDo().get(0).getName());

		removeListForUser("Kalle", "Ärenden"); // Tar bort listan efter den skapades

		// Skriver ut alla listor kalle har
		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals("Kalle")) {
				System.out.println("Namn på Kalles listor: ");
				for (ListOfToDos toDoList : user.getToDoLists()) {
					System.out.println(toDoList.getNameOfList() + " ");
				}
			}
		}

	}

	public static void addNewListForUser(String username, String nameOfList) {
		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals(username)) {
				user.getToDoLists().add((new ListOfToDos(null, nameOfList, UUID.randomUUID())));
			}
		}
	}

	public static void removeListForUser(String username, String nameOfList) {
		for (User user : userlist.getUserList()) {
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

	public static void addNewToDoForUser(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
		for (User user : userlist.getUserList()) {
			if (user.getUsername().equals(username)) {
				for (ListOfToDos list : user.getToDoLists()) {
					if (list.getNameOfList().equals(nameOfList)) {
						user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDo()
								.add(new ToDo(nameOfToDo, timeOfToDo, false));
					}
				}
			}
		}
	}
}
