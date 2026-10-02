package org.example;

public class Task {
    // private int id; id users
    private String name; // Название задачи
    private boolean ready; // Флаг готовности задачи

    Task(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean getReady(){
        return ready;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void setName(String name) {
        this.name = name;
    }
}
