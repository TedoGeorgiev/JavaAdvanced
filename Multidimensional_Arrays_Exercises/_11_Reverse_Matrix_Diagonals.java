package Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _11_Reverse_Matrix_Diagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        // print first part
        for (int c = cols - 1; c > 0 ; c--) { // това са броя на диагоналите
            for (int row = rows - 1, col = c; row >= 0 && col < cols; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // print second part
        for (int r = rows - 1; r >= 0 ; r--) {
            for (int row = r, col = 0; row >= 0 && col < cols ; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }



    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
