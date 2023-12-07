package com.thetask.demo;

import java.time.LocalDate;

public class ToDo {
    private static Long taskIdCounter = 1L;

    private Long id;
    private String name;
    private LocalDate deadline;
    private boolean isDone;
    private ListOfToDos listoftodos;

    public ToDo(String name, LocalDate deadline, ListOfToDos listoftodos) {
        this.id = taskIdCounter++;
        this.name = name;
        this.deadline = deadline;
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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
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

}
