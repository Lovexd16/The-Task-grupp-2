package com.thetask.demo;

import java.util.ArrayList;

public class ListOfToDos {

    private ArrayList<ToDo> ListOfToDos;
    private String nameOfList;

    public ListOfToDos(ArrayList<ToDo> ListOfToDos, String nameOfList) {
        this.ListOfToDos = new ArrayList<>();
        this.nameOfList = nameOfList;
    }

    public static void removeToDo(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDos()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDos().remove(todo);
                            }
                        }
                    }
                }
            }
        }
    }

    public long editToDoTime(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDos()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDos().get(list.getListOfToDos().indexOf(todo)).setTime(timeOfToDo);
                                return timeOfToDo;
                            }
                        }
                    }
                }
            }
        }
        return timeOfToDo;
    }

    public String editToDoName(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDos()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDos().get(list.getListOfToDos().indexOf(todo)).setName(nameOfToDo);
                                return nameOfToDo;

                            }
                        }
                    }
                }
            }
        }
        return nameOfToDo;
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