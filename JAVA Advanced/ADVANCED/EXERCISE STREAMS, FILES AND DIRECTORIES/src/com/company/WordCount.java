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

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> wordsAndCount = new HashMap<>();
        try {
            FileWriter fileWriter = new FileWriter(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            List<String> strings = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
            List<String> target = Files.readAllLines(Path.of("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
            String[] text = target.get(0).replaceAll(",", "").split("\\s+");
            for (String word : strings.get(0).split("\\s+")) {
                wordsAndCount.put(word, 0);
                for (String targetWord : text) {
                    if (word.equals(targetWord)) {
                        int count = wordsAndCount.get(word) + 1;
                        wordsAndCount.put(word, count);
                    }
                }
            }
wordsAndCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .forEach(entry -> {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
