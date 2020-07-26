package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser"));
        for (Integer number : numbers) {
            objectOutputStream.write(number);
        }
    }
}
