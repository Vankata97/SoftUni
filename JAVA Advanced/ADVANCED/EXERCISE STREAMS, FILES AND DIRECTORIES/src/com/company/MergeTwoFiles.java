package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoFiles {
    public static void main(String[] args) {
        Map<String, Integer> wordsAndCount = new HashMap<>();
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            List<String> fileOne = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
            List<String> fileTwo = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
            for (String word : fileOne) {
                fileWriter.write(word + "\n");
                fileWriter.flush();
            }
            for (String word : fileTwo) {
                fileWriter.write(word + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
