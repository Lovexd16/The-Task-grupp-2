package com.thetask.demo;

public class ListOfToDos {
    private static Long todoListIdCounter = 1L;

    private Long id;
    private String name;
    private User user;

    public ListOfToDos(String name, User user) {

        this.name = name;
        this.user = user;
    }

    // Getter och setter-metoder

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
// public static void removeToDo(String username, String nameOfList, String

// nameOfToDo) {
// for (User user : ThetaskApplication.userlist.getUserList()) {
// if (user.getUsername().equals(username)) {
// for (ListOfToDos list : user.getToDoLists()) {
// if (list.getname().equals(nameOfList)) {
// for (ToDo todo : list.getListOfToDo()) {
// if (todo.getName().equals(nameOfToDo)) {
// list.getListOfToDo().remove(todo);
// }}}}}}}}

// kanske utöka metod till att kolla mot tiden oxå, kan man ha 2 same-namtodos
// då kanske?
