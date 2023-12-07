package com.thetask.demo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ToDo {
    private String name;
    private LocalTime time;
    private LocalDate date;
    private boolean isDone;

    public ToDo(String name, LocalDate date, LocalTime time , boolean isDone) {
        this.name = name;
        this.time = time;
        this.date = date;
        this.isDone = false;
    }

    
    public LocalTime getTime() {
        return time;
    }


    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }


    public void setTime(LocalTime time) {
        this.time = time;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        isDone = true;
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

}
