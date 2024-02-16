package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _7_Find_the_Smallest_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[] :: new);

        Function<Integer [], Integer> findSmallestNumber = arr ->
                Arrays.stream(arr).min((a, b) -> a.compareTo(b)).get();

        Object smallIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(findSmallestNumber.apply(numbers))) {
                smallIndex = i;
            }
        }
        System.out.println(smallIndex);
    }
}
