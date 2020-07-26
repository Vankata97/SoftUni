package com.company;

import java.io.*;

public class CopyOfPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\googleLogo.jpg"));
        FileOutputStream outputStream = new FileOutputStream(new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\destination.jpg"));
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, read);
        }
    }
}
