package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _4_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArr(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int [] arr = readArr(scanner);
            matrix[i] = arr;
        }

        int sum = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sum += matrix[r][c];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
