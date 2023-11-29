package com.thetask.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThetaskApplication.class, args);

		UserList users = new UserList();
		users.addUser("Kalle", "123");

		ToDo stada = new ToDo("Städa", CurrentTime.getCurrentTime(), false);
		ToDo tvatta = new ToDo("Tvätta", CurrentTime.getCurrentTime() - 5000, true);
		ArrayList<ToDo> kallesToDoList = new ArrayList<>();
		kallesToDoList.add(stada);
		kallesToDoList.add(tvatta);

		User lennart = new User("Lennart", "1234");
		System.out.println("Lennarts storlek utan Kalle i sig " + lennart.toDoLists.size());
		lennart.addToDoList(kallesToDoList);

		System.out.println("Lennarts storlek med Kalle i sig " + lennart.toDoLists.size());
		System.out.println(lennart.getToDoLists().get(0).get(0).getName());

		System.out.println("Städa tid: " + stada.getTime());
		System.out.println("Städa namn: " + stada.getName());
		System.out.println("Tvätta tid: " + tvatta.getTime());

	}

}
