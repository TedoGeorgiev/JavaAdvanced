package Functional_Programming_Exercises;

import java.util.*;
import java.util.function.Function;

public class _3_Custom_Min_Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer [], Integer> findMin = arr -> Arrays.stream(arr).min((a, b) -> a.compareTo(b)).get();

        Integer [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(findMin.apply(numbers));

    }

}
