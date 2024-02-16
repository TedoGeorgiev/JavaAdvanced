package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _2_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printFormat = s -> System.out.println("Sir " + s);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printFormat);
    }
}
