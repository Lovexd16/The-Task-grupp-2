package com.thetask.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class listTests {

    @Test
    public void removeObjectTest() {

        ArrayList<String> toDos = new ArrayList<String>(); // Skapar en enkel String Array lista

        String städa = "Städa"; // deklarerar några strings
        String plugga = "Plugga";
        String träna = "Träna";

        toDos.add(städa); // Lägger till strings i Arrayen
        toDos.add(plugga);
        toDos.add(träna);

        toDos.remove(städa); // Tar bort en string från listan

        ArrayList<String> testResult = List.removeObject(toDos);

        assertEquals(2, testResult.size()); // Förväntas innehålla 2 strängar
    }

}
