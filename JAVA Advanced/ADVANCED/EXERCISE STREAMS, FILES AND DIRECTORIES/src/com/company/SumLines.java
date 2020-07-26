package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLines {

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            List<String> strings = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            for (String string : strings) {
                long asciiSum = 0;
                for (int i = 0; i < string.length(); i++) {
                    asciiSum += string.charAt(i);
                }
                System.out.println(asciiSum);
                fileWriter.write(asciiSum + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
