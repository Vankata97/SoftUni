package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GetFolderSize {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            File file = new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
            int size = 0;
            for (File currentFile : file.listFiles()) {
                size += currentFile.length();
            }
            System.out.println(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
