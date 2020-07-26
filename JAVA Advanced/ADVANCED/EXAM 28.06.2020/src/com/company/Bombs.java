import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffect::offer);
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasing::push);

        int cherryBombsPrice = 60;
        int daturaBombsPrice = 40;
        int smokeBombsPrice = 120;

        int cherryBombs = 0;
        int daturaBombs = 0;
        int smokeBombs = 0;

        while (!bombEffect.isEmpty() && !bombCasing.isEmpty()) {
            int bombEffectNum = bombEffect.peek();
            int bombCasingNum = bombCasing.peek();

            int sum = bombEffectNum + bombCasingNum;

            if (sum == daturaBombsPrice) {
                bombEffect.pop();
                bombCasing.poll();
                daturaBombs++;

            } else if (sum == cherryBombsPrice) {
                bombEffect.pop();
                bombCasing.poll();
                cherryBombs++;

            } else if (sum == smokeBombsPrice) {
                bombEffect.pop();
                bombCasing.poll();
                smokeBombs++;

            } else {
                int getCasingNum = bombCasing.pop();
                getCasingNum -= 5;
                bombCasing.push(getCasingNum);
            }

            if (cherryBombs >= 3 && daturaBombs >= 3 && smokeBombs >= 3) {
                break;
            }
        }

        if (cherryBombs >= 3 && daturaBombs >= 3 && smokeBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        List<String> effectList = new ArrayList<>();
        while (!bombEffect.isEmpty()) {
            effectList.add(String.valueOf(bombEffect.poll()));
        }

        System.out.print("Bomb Effects: ");
        if (!effectList.isEmpty()) {

            System.out.println(effectList.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        } else {
            System.out.println("empty");
        }

        List<String> casingList = new ArrayList<>();
        while (!bombCasing.isEmpty()) {
            casingList.add(String.valueOf(bombCasing.pop()));
        }

        System.out.print("Bomb Casings: ");
        if (!casingList.isEmpty()) {

            System.out.println(casingList.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        } else {
            System.out.println("empty");
        }

        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeBombs);
    }

}