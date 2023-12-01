package com.thetask.demo;

import java.util.ArrayList;

public class ListOfToDos {

    private ArrayList<ToDo> ListOfToDos;
    private String nameOfList;

    public ListOfToDos (ArrayList<ToDo> ListOfToDos, String nameOfList) {
        this.ListOfToDos = new ArrayList<>();
        this.nameOfList = nameOfList;
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