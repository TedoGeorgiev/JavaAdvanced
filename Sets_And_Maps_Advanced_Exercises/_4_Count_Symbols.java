package Sets_And_Maps_Advanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!symbolsMap.containsKey(ch)) {
                symbolsMap.put(ch, 1 );

            } else {
                symbolsMap.put(ch, symbolsMap.get(ch) + 1);
            }
        }

        symbolsMap.forEach((key, value) -> {
            System.out.printf("%c: %d time/s%n", key, value);
        });
    }
}
