package com.thetask.demo;

import java.util.ArrayList;

public class ListOfToDos {

    private ArrayList<ToDo> ListOfToDos;
    private String nameOfList;

    ListOfToDos(ArrayList<ToDo> ListOfToDos, String nameOfList) {
        this.ListOfToDos = new ArrayList<>();
        this.nameOfList = nameOfList;
    }

    public static void removeToDo(String username, String nameOfList, String nameOfToDo) {
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDo()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDo().remove(todo);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void setToDoAsDone(String username, String nameOfList, String nameOfToDo) {
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDo()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDo().get(list.getListOfToDo().indexOf(todo)).setIsDone(true);
                                ;
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<ToDo> getListOfToDo() {
        return ListOfToDos;
    }

    public void setListOfToDo(ArrayList<ToDo> listOfToDo) {
        ListOfToDos = listOfToDo;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }


}