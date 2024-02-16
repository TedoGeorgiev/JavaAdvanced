package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _6_Print_Diagonals_of_Square_Matrix_WithWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        int[][] squareMatrix = new int[size][size];

        for (int i = 0; i < squareMatrix.length; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            squareMatrix[i] = arr;
        }

        int row = 0, col = 0;

        while (row < squareMatrix.length && col < squareMatrix.length) {
            System.out.print(squareMatrix[row][col] + " ");
            row++;
            col++;
        }

        System.out.println();

        row = squareMatrix.length - 1;
        col = 0;
        while (row >= 0 && col < squareMatrix.length) {
            System.out.print(squareMatrix[row][col] + " ");
            row--;
            col++;
        }

        System.out.println();

    }
}
