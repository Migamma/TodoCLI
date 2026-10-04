package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TaskStorage {
    private String nameFile;

    public void createStorage(String nameFile){
        this.nameFile = nameFile;
        Path path = Paths.get("data" , nameFile);
        try{

            if (path.getParent() != null){
                Files.createDirectories(path.getParent());
            }

            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Sucfully! File created.");
            } else{
                System.out.println("Error! File with same names was created.");
            }
        } catch (IOException e){
            System.out.println("Error! Imposible to create the file.");
        }
    }

    public void writeFile(ArrayTask arr){
        Path path = Paths.get("data" , nameFile);

        ArrayList<String> name = new ArrayList<>();
        try {
            Files.writeString(path, arr.searchIndex(0).getName()  + "\n");
            for (int i = 1; i < arr.lengthArray(); i++){
                    name.add(arr.searchIndex(i).getName());
            }
            Files.write(path, name, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e){
            System.out.println("ERROR! Saving failed.");
        }
    }

    public void readFile(String nameFile){
        Path path = Paths.get("data", nameFile);

        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("ERROR! While reading the file.");
        }
    }
}
