package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SantaPresentFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] materials = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();

    }
}
