package Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _3_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        fillMatrix(scanner, matrix);

        int sum;
        sum = Math.abs(firstDiag(matrix) - secondDiag(matrix));

        System.out.println(sum);
    }

    private static int secondDiag(int[][] matrix) {
        int cols = 0;
        int sum = 0;
        for (int rows = matrix.length - 1; rows >= 0; rows--) {
            sum += matrix[rows][cols];
            cols++;
        }
        return sum;
    }

    private static int firstDiag(int[][] matrix) {
        int cols = 0;
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            sum += matrix[rows][cols];
            cols++;
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = readArr(scanner);
        }

    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
