package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _6_Print_Diagonals_of_Square_Matrix_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][]squareMatrix = new int[n][n];

        fillMatrix(scanner, squareMatrix);

        printFirstDiag(squareMatrix);
        System.out.println();
        printSecondDiag(squareMatrix);
        System.out.println();
    }

    private static void printSecondDiag(int[][] squareMatrix) {
        for (int row = squareMatrix.length - 1; row >= 0 ; row--) {
            System.out.print(squareMatrix[row][squareMatrix.length - row - 1] + " ");
        }
    }

    private static void printFirstDiag(int[][] squareMatrix) {
        for (int row = 0; row < squareMatrix.length; row++) {
            System.out.print(squareMatrix[row][row] + " ");
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] squareMatrix) {
        for (int row = 0; row < squareMatrix.length; row++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            squareMatrix[row] = arr;

         }
    }
}
