package Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class _3_Voina_Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (int i = 0; i < 50; i++) {


            var firstCard = firstDeck.iterator().next();
            var secondCard = secondDeck.iterator().next();
            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);

            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);

            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }


        String output;
        if (firstDeck.size() > secondDeck.size()) {
            output = "First player win!";
        } else {
            output = "Second player win!";
        }

        System.out.println(output);
    }
}
