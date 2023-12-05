package com.thetask.demo;

import java.util.ArrayList;
import java.util.UUID;

public class ListOfToDos {

    private ArrayList<ToDo> ListOfToDo;
    private String nameOfList;
    private UUID id;

    ListOfToDos(ArrayList<ToDo> ListOfToDo, String nameOfList, UUID id) {
        this.ListOfToDo = new ArrayList<>();
        this.nameOfList = nameOfList;
        this.id = id;
    }

    public static void removeToDo(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
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

    public long editToDoTime(String username, String nameOfList, String nameOfToDo, long timeOfToDo) {
        for (User user : ThetaskApplication.userlist.getUserList()) {
            if (user.getUsername().equals(username)) {
                for (ListOfToDos list : user.getToDoLists()) {
                    if (list.getNameOfList().equals(nameOfList)) {
                        for (ToDo todo : list.getListOfToDo()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDo().get(list.getListOfToDo().indexOf(todo)).setTime(timeOfToDo);
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
                        for (ToDo todo : list.getListOfToDo()) {
                            if (todo.getName().equals(nameOfToDo)) {
                                list.getListOfToDo().get(list.getListOfToDo().indexOf(todo)).setName(nameOfToDo);
                                return nameOfToDo;

                            }
                        }
                    }
                }
            }
        }
        return nameOfToDo;
    }

    public ArrayList<ToDo> getListOfToDo() {
        return ListOfToDo;
    }

    public void setListOfToDo(ArrayList<ToDo> listOfToDo) {
        ListOfToDo = listOfToDo;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}