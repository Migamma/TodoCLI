package org.example;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        ArrayTask arr = new ArrayTask();

        Scanner in = new Scanner(System.in);

        String command = "start";

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
                }
            } else if (command.equals("END")) {
                break;
            } else{
                System.out.println("Введите правильную команду");
            }
        }
    }
}