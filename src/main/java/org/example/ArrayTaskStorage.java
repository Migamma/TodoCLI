package org.example;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class ArrayTaskStorage {
    private ArrayList<TaskStorage> files = new ArrayList<>();

    public ArrayList<TaskStorage> getFiles(){
        return files;
    }

}
