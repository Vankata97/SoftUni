
package greedyTimes;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] treasure = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < treasure.length; i += 2) {
            String item = treasure[i];
            long quantity = Long.parseLong(treasure[i + 1]);

            String name = "";

            if (item.length() == 3) {
                name = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                name = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                name = "Gold";
            }

            if (name.equals("")) {
                continue;
            } else if (bag.getCapacity() < quantity) {
                continue;
            }

            switch (name) {
                case "Gem":

                    if (!bag.doesGemsContainsGem(name)) {
                        if (bag.getGold() != null) {
                            if (quantity > bag.getGold().getValue()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.totalGems() + quantity > bag.getGold().getValue()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsCash(name)) {
                        if (bag.getGems().size() > 0) {
                            if (quantity > bag.getGold().getValue()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.totalCash() + quantity > bag.totalGems()) {
                        continue;
                    }
                    break;
                case "Gold":
                    if (bag.getGold() == null) {
                        bag.setGold(new Gold(quantity));
                    } else {
                        Gold gold = bag.getGold();
                        gold.setValue(gold.getValue() + quantity);
                        bag.setGold(gold);
                    }
                    break;
            }

            if (!bag.containsKey(name)) {
                bag.put((name), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(name).containsKey(item)) {
                bag.get(name).put(item, 0L);
            }


            bag.get(name).put(item, bag.get(name).get(item) + quantity);

        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}