package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Card Ranks:");
        for (CardRank card : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(), card.name());
        }

    }
}
