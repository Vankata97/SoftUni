package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));

        String rank = reader.readLine();
        String suit = reader.readLine();

        CardRank cardRank = CardRank.valueOf(rank);
        CardSuit cardSuit = CardSuit.valueOf(suit);
        int power = cardRank.getPower() + cardSuit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", cardRank.name(), cardSuit.name(), power);

    }
}
