package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _5_Reverse_and_Exclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> isDivisibleByN = number -> number % n != 0;

        numbers.stream().filter(isDivisibleByN).forEach(e -> System.out.print(e + " "));

    }
}
