package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _6_Print_Diagonals_of_Square_Matrix_WithFor {
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

        for (int i = 0; i < squareMatrix.length; i++) {
            System.out.print(squareMatrix[i][i] + " ");
        }

        System.out.println();

        for (int i = 0; i < squareMatrix.length; i++) {
            int lastRowIndex = squareMatrix.length - 1;
            System.out.print(squareMatrix[lastRowIndex - i][i] + " ");
        }

        System.out.println();
    }
}
