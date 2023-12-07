package com.thetask.demo;

import java.util.ArrayList;
import java.util.List;

public class ListOfToDos {
    private static Long todoListIdCounter = 1L;

    private Long id;
    private String name;
    private User user;
    private List<ToDo> tasks;

    public ListOfToDos(String name, User user) {
        this.id = todoListIdCounter++;
        this.name = name;
        this.user = user;
        this.tasks = new ArrayList<>();
    }

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

    public List<ToDo> getTasks() {
        return tasks;
    }

    public void setTasks(List<ToDo> tasks) {
        this.tasks = tasks;
    }

    public void addTask(ToDo task) {
        tasks.add(task);
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
