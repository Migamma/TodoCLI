package org.example;
import java.util.ArrayList;

public class ArrayTask {
    private ArrayList<Task> object = new ArrayList<>();

    public void newTask(String name){
        Task obj = new Task(name);
        object.add(obj);
    }

    public void deleteTask(String name){
        for (int i = 0; i < object.size(); i++){
            Task obj = object.get(i);
            if (obj.getName().equals(name)){
                object.remove(obj);
            }
        }
    }

    public void showArray(){
        System.out.println("Название | Готовность");
        for (Task obj : object){
            System.out.println(obj.getName() + " | " + obj.getReady());
        }
    }
}
