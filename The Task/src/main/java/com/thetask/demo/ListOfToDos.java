package com.thetask.demo;

import java.util.ArrayList;

public class ListOfToDos {

    private ArrayList<ToDo> ListOfToDos;
    private String nameOfList;

    public ListOfToDos(ArrayList<ToDo> ListOfToDos, String nameOfList) {
        this.ListOfToDos = new ArrayList<>();
        this.nameOfList = nameOfList;
    }

    // FIXA DETTA!!! KNAS!!! *********************************
    public void removeToDo(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {

                    if (list.getNameOfList().equals(nameOfList)) {
                        user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDos().remove()/*
                                                                                                             * .remove()
                                                                                                             * loopa
                                                                                                             * igenom
                                                                                                             * listan
                                                                                                             * och
                                                                                                             * ta bort
                                                                                                             * om
                                                                                                             * nameOfToDo
                                                                                                             * ==
                                                                                                             * nameOfToDo
                                                                                                             */;
                    }
                }
            }
        }
    }

    // FIXA DETTA!!! KNAS!!! *********************************
    public void editToDoTime(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDos();
                    }
                }
            }
        }
    }

    // FIXA DETTA!!! KNAS!!! *********************************
    public void editToDoName(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        user.getToDoLists().get(user.getToDoLists().indexOf(list)).getListOfToDos();
                    }
                }
            }
        }
    }

    public ArrayList<ToDo> getListOfToDos() {
        return ListOfToDos;
    }

    public void setListOfToDos(ArrayList<ToDo> listOfToDos) {
        ListOfToDos = listOfToDos;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }

}