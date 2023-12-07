package com.thetask.demo;

public class User {
    private static Long userIdCounter = 1L;

    private Long id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.id = userIdCounter++;
        this.username = username;
        this.password = password;
    }

    // Getter och setter-metoder

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// import java.util.ArrayList;
// import java.util.List;
// import java.util.UUID;

// public class User {

// private String username;
// private String password;
// private ArrayList<ListOfToDos> toDoLists;

// User(String username, String password) {
// this.username = username;
// this.password = password;
// this.toDoLists = new ArrayList<>();

// }

// public void addTodoList(ArrayList<ListOfToDos> listOfToDo, String username,
// String nameOfList, UUID id) {

// // for (ListOfToDos existingList : listOfToDo) {
// // if (existingList.getId().equals(id)) {
// // System.out.println("En lista med samma ID finns redan.");
// // return;
// // }
// // }

// // // Skapa en ny lista och lägg till den i listan av att-göra-listor
// // ListOfToDos newList = new ListOfToDos(new ArrayList<>(), nameOfList, id);
// // listOfToDo.add(newList);

// // System.out.println("Lista tillagd framgångsrikt.");
// // ListOfToDos listOfToDos = findUserTodoLists(listOfToDo, username);
// ListOfToDos newList = new ListOfToDos(new ArrayList<>(), nameOfList, id);
// getToDoLists().add(newList);
// }
// // private ListOfToDos findUserTodoLists(List<ListOfToDos> listoftodos,
// String
// // username) {
// // // Letar efter användaren i listan, skapar en ny om den inte finns
// // for (ListOfToDos listOfToDos2 : toDoLists) {
// // if (listOfToDos.getUserId().equals(username)) {
// // return listOfToDos;
// // }
// // }

// // // Skapa en ny användare om den inte finns
// // UserTodoLists newUserLists = new UserTodoLists(userId, new ArrayList<>());
// // userTodoLists.add(newUserLists);
// // return newUserLists;

// public String getUsername() {
// return username;
// }

// public void setUsername(String username) {
// this.username = username;
// }

// public String getPassword() {
// return password;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// public ArrayList<ListOfToDos> getToDoLists() {
// return toDoLists;
// }

// public void setToDoLists(ArrayList<ListOfToDos> toDoLists) {
// this.toDoLists = toDoLists;
// }

// }
