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
        System.out.println("Number | Name | Ready");
        for (int i = 0 ; i < object.size(); i++){
            Task obj = object.get(i);
            System.out.println((i + 1) + " | " + obj.getName() + " | " + obj.getReady());
        }
    }

    public void readyTask(String name, String flag){
        for (Task obj : object){
            if (obj.getName().equals(name)){
                if (flag.equals("y")){
                    obj.setReady(true);
                } else if (flag.equals("n")){
                    obj.setReady(false);
                } else{
                    System.out.println("Unable to determine the state");
                }
            }
        }
    }

    public void rename(String name, String newName){
        for (Task obj : object){
            if (obj.getName().equals(name)){
                obj.setName(newName);
            }
        }
    }

    public int lengthArray(){
        return object.size();
    }

    public Task searchIndex(int index){
        return object.get(index);
    }

}
