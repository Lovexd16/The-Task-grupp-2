package com.thetask.demo;

import java.util.ArrayList;

public class List {

    public static ArrayList<String> removeObject(ArrayList<String> toDos) {
        String städa = "Städa";
        toDos.add(städa);

        if (toDos.contains(städa)) {
            toDos.remove(städa);
        }
        return toDos;
    }

}
