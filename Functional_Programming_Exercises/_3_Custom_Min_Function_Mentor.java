package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _3_Custom_Min_Function_Mentor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[] :: new);

        Function<Integer [], Integer> findSmallestNumber = arr ->
                Arrays.stream(arr).min((a, b) -> a.compareTo(b)).get();

        System.out.println(findSmallestNumber.apply(numbers));
    }
}
