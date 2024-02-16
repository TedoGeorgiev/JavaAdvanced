package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _4_Sum_Matrix_Elements_EasyWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        int total = 0;
        for (int i = 0; i < rows; i++) {
            int sum = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .sum();
            total += sum;
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(total);

    }
}
