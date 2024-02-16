package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _4_Sum_Matrix_Elements_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] matrixSize = readArr(scanner);

        int r = matrixSize[0];
        int c = matrixSize[1];

        int[][] matrix = new int[r][c];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = readArr(scanner);
            matrix[i] = arr;
        }

        System.out.println(r);
        System.out.println(c);
        int sum = 0;

        for (int[] rows : matrix) {
            for (int number : rows) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
