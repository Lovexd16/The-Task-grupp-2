package com.thetask.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ToDo {
    private static Long taskIdCounter = 1L;

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private boolean isDone;
    private ListOfToDos listoftodos;

    public ToDo(String name, LocalDate date, LocalTime time) {
        this.id = taskIdCounter++;
        this.name = name;
        this.date=date;
        this.time=time;
        this.isDone = false;
        this.listoftodos = listoftodos;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public static Long getTaskIdCounter() {
        return taskIdCounter;
    }

    public static void setTaskIdCounter(Long taskIdCounter) {
        ToDo.taskIdCounter = taskIdCounter;
    }

    public ListOfToDos getListoftodos() {
        return listoftodos;
    }

    public void setListoftodos(ListOfToDos listoftodos) {
        this.listoftodos = listoftodos;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

  
}
