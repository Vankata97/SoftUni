package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {
        List<String> strings;
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            strings = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

            for (String string : strings) {

                fileWriter.write(string.toUpperCase() + "\n");
                fileWriter.flush();
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}