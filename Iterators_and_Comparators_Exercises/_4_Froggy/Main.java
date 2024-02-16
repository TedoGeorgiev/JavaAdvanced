package Iterators_and_Comparators_Exercises._4_Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(line.split(", "))
               .map(Integer::parseInt)
                       .collect(Collectors.toList());

        Lake lake = new Lake(numbers);


        StringBuilder sb = new StringBuilder();
        for (Integer i : lake) {
            sb.append(i + ", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2));

    }
}
