package com.thetask.demo;

import java.util.ArrayList;

public class ListOfToDos {
    
    private ArrayList<ToDo> ListOfToDos;

    public void putToDosInList(String name, long time) {
        ListOfToDos.add(new ToDo(name, time, false));
    }
}
