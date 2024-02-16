package AlgorithmsBasics;

import java.util.*;

public class _3_Sum_of_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int changeInSt = (int) (change * 100);

        Map<Integer, Integer> coinsMap = new HashMap<>();

        coinsMap.put(10, 0);
        coinsMap.put(5, 0);
        coinsMap.put(2, 0);
        coinsMap.put(1, 0);

        while (changeInSt > 0) {

            if (changeInSt >= 10) {
                coinsMap.put(10, coinsMap.get(10) + 1);
                changeInSt -= 10;

            } else if (changeInSt >= 5) {
                coinsMap.put(5, coinsMap.get(5) + 1);
                changeInSt -= 5;

            } else if (changeInSt >= 2) {
                coinsMap.put(2, coinsMap.get(2) + 1);
                changeInSt -= 2;

            } else if (changeInSt >= 1){
                coinsMap.put(1, coinsMap.get(1) + 1);
                changeInSt -= 1;
            }
        }

        coinsMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .forEach(entry -> System.out.printf("%d st: %d%n", entry.getKey(), entry.getValue()));

    }
}
