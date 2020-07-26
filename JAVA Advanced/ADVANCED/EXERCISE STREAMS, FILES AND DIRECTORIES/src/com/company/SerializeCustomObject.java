package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser"));

        Course course = new Course("Java Advanced", 146);
        objectOutputStream.writeObject(course);
    }

    public static class Course implements Serializable {
        private String name;
        private Integer students;
        public Course(String name, Integer students) {
            this.name = name;
            this.students = students;
        }
    }
}
