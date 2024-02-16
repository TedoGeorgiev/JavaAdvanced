package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class _7_Hands_Of_Cards_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Set<String>> namesMap = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"JOKER".equals(line)) {

            String name = line.split(": ")[0];
            String allCards = line.split(": ")[1];

            String [] card = allCards.split(", ");

            namesMap.putIfAbsent(name, new HashSet<>());
            Set<String> cardsSet = namesMap.get(name);
            cardsSet.addAll(Arrays.asList(card));

            line = scanner.nextLine();
        }

        namesMap.forEach((key, value) -> {
            int sum = getSum(value);
            System.out.printf("%s: %d\n", key, sum);
        });

    }

    private static int getSum(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            String first = card.substring(0, card.length() - 1);
            String second = card.substring(card.length() - 1);
            int power;

            switch (first) {
                case "J":
                    power = 11;
                    break;

                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
                default:
                    power = Integer.parseInt(first);
                    break;
            }
            int type = 0;
            switch (second) {

                case "S":
                    type = 4;
                    break;
                case "H":
                    type = 3;
                    break;
                case "D":
                    type = 2;
                    break;
                case "C":
                    type = 1;
                    break;
            }
            sum += (power * type);
        }

        return sum;
    }
}
