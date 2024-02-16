package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _1_Consume_Print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String > printFormat = System.out::println;
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printFormat);

    }
}
