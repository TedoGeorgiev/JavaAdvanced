package Functional_Programming_Exercises;

import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Predicate;

public class _6_Predicate_for_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Predicate<String> filterByLength = s -> s.length() <= number;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(filterByLength)
                .forEach(System.out::println);

    }
}
