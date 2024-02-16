package Sets_And_Maps_Advanced_Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = size[0];
        int m = size[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        addNumbers(n, scanner, firstSet);
        addNumbers(m, scanner, secondSet);

        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));

    }

    private static void addNumbers(int n, Scanner scanner, Set<Integer> firstSet) {
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }
    }
}
