package org.example;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ArrayTask arr = new ArrayTask();

        TaskStorage file = new TaskStorage();

        Scanner in = new Scanner(System.in);

        String command = "start";
        String ready;
        String newName;

        while (!command.equals("END")){

            command = in.nextLine();
            if (command.equals("SHOW")) {
                arr.showArray();
                continue;
            }
            command = command.strip();

            int index = command.indexOf(" ");

            if (index != -1) {

                String name = command.substring(index + 1);
                command = command.substring(0, index);


                if (command.equals("ADD")) {
                    arr.newTask(name);

                } else if (command.equals("DELETE")) {
                    arr.deleteTask(name);

                } else if (command.equals("READY")){
                    System.out.println("Is the task ready? y/n");
                    ready = in.nextLine();
                    arr.readyTask(name, ready);

                } else if (command.equals("RENAME")){
                    System.out.println("Enter the new name: ");
                    newName = in.nextLine();
                    arr.rename(name, newName);

                } else if (command.equals("CREATE")) {
                    file.createStorage(name);

                } else if (command.equals("WRITE")){
                    file.writeFile(arr);
                }
            } else if (command.equals("END")) {
                break;
            } else{
                System.out.println("ERROR! Enter the correct command");
            }
        }
    }
}