package Sets_And_Maps_Advanced_Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class _7_Hands_Of_Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Peter: 2C, 4H, 9H, AS, QS
        Map<String, LinkedHashSet<String>> cardsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"JOKER".equals(input)) {

            String name = input.split(": ")[0];
            String cards = input.split(": ")[1].replaceAll(" ", "");

            String [] cardsArray = cards.split(",");
            LinkedHashSet<String> cardSet = new LinkedHashSet<>(Arrays.asList(cardsArray));

            if (!cardsMap.containsKey(name)) {
                cardsMap.put(name, cardSet);

            } else {
                LinkedHashSet<String> currentSet = cardsMap.get(name);
                currentSet.addAll(List.of(cardsArray));
                cardsMap.put(name, currentSet);
            }

            input = scanner.nextLine();
        }

        cardsMap.forEach((key, value) -> {
            int sum = getSum(value);
            System.out.printf("%s: %d%n", key, sum);
        });
    }

    private static int getSum(LinkedHashSet<String> cardSet) {
        int sum = 0;
        for (String e : cardSet) {
            int power = 0;
            int multiplier = 0;
            String first = e.substring(0, e.length() - 1);
            //P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A)

            if (first.equals("J")) {
                power = 11;
            } else if (first.equals("Q")) {
                power = 12;
            } else if (first.equals("K")) {
                power = 13;
            } else if (first.equals("A")) {
                power = 14;
            } else {
                power = Integer.parseInt(first);
            }

            String last = e.substring(e.length()-1);
            //(S -> 4, H-> 3, D -> 2, C -> 1).
            if (last.equals("S")) {
                multiplier = 4;
            } else if (last.equals("H")) {
                multiplier = 3;
            } else if (last.equals("D")) {
                multiplier = 2;
            } else if (last.equals("C")) {
                multiplier = 1;
            }

            sum += power * multiplier;
        }

        return sum;
    }
}
