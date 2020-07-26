package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TrafficLights[] lights = Arrays.stream(reader.readLine().split(" "))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);
        int n = Integer.parseInt(reader.readLine());
        TrafficLights[] trafficLights = TrafficLights.values();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                TrafficLights light = lights[j];
                int nextIndex = light.ordinal() + 1;
                TrafficLights value = trafficLights[nextIndex % trafficLights.length];
                lights[j] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

//Alternative way:
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        TrafficLights[] lights = Arrays.stream(reader.readLine().split(" "))
//                .map(TrafficLights::valueOf)
//                .toArray(TrafficLights[]::new);
//        int n = Integer.parseInt(reader.readLine());
//        TrafficLights[] trafficLights = TrafficLights.values();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < lights.length; j++) {
//                TrafficLights current = lights[i];
//                TrafficLights next = nextLigh(current);
//                trafficLights[i] = next;
//                System.out.print(current + " ");
//            }
//            System.out.println();
//        }
//    }
//    private static TrafficLights nextLigh(TrafficLights light) {
//        switch (light.name()) {
//            case "RED":
//                return TrafficLights.GREEN;
//            case "YELLOW":
//                return TrafficLights.RED;
//            case "GREEN":
//                return TrafficLights.YELLOW;
//        }
//        return null;
//    }
}
