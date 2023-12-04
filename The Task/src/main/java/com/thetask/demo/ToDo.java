package com.thetask.demo;

public class ToDo {
    private String name;
    private long time;
    private boolean isDone;

    public ToDo(String name, long time, boolean isDone) {
        this.name = name;
        this.time = time;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isDone() {
        isDone = true;
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

}
