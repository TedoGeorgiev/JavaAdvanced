package Sets_And_Maps_Advanced_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_Count_Symbols_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolMap= new TreeMap<>();

        for (char c : scanner.nextLine().toCharArray()) {
            if (!symbolMap.containsKey(c)) {
                symbolMap.put(c, 1);
            } else {
                symbolMap.put(c, symbolMap.get(c) + 1);
            }
        }

        symbolMap.forEach((k, v) -> System.out.printf("%c: %d time/s\n", k, v));
    }
}
