package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskStorage {
    private String nameFile;

    public void CreateStorage(String nameFile){
        this.nameFile = nameFile;
        Path path = Paths.get("data" , nameFile);
        try{

            if (path.getParent() != null){
                Files.createDirectories(path.getParent());
            }

            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Sucfully! File created");
            } else{
                System.out.println("Error! File with same names was created");
            }
        } catch (IOException e){
            System.out.println("Error! Imposible to create the file");
        }
    }
}
