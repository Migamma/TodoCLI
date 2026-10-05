package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
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

    public void firstWriteFile(ArrayTask arr){
        Path path = Paths.get("data" , nameFile);
        ArrayList<String> name = new ArrayList<>();
        try{
            if (Files.exists(path) && Files.size(path) == 0){
                try {
                    Files.writeString(path, "Number | Name | Ready" + "\n");
                    Files.writeString(path,1 + " | " +   arr.searchIndex(0).getName()  + " | " + arr.searchIndex(0).getReady() + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    for (int i = 1; i < arr.lengthArray(); i++){
                        name.add((i + 1) + " | " + arr.searchIndex(i).getName() + " | " + arr.searchIndex(i).getReady());
                    }
                    Files.write(path, name, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    System.out.println("Write in file is successfully");
                } catch (IOException e){
                    System.out.println("ERROR! Saving failed.");
                }
            } else{
                System.out.println("Initial write to the file is not possible");
            }
        } catch (IOException e){
            System.out.println("Error! File is not empty");
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
