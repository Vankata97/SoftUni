package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            String file = String.join("", Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt")));
            for (int i = 0; i < file.length(); i++) {
                char symbol = file.charAt(i);
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    countVowels++;
                } else if (Character.isLetterOrDigit(symbol) || symbol == '\'' || symbol == '-') {
                    countConsonants++;
                } else if (symbol == '!' || symbol == '?' || symbol == ',' || symbol == '.') {
                    countPunctuation++;
                }
            }
            fileWriter.write(String.format("Vowels: %d\n" + "Consonants: %d\n" + "Punctuation: %d", countVowels, countConsonants, countPunctuation));
            fileWriter.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
