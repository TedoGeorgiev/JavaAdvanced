package Multidimensional_Arrays_Exercises;

import java.util.Scanner;

public class _1_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int [][] matrix = new int[size][size];

        switch (pattern) {

            case "A":
                fillMatrixA(matrix);
                break;

            case "B":
                fillMatrixB(matrix);
                break;

        }
        printMatrix(matrix);

    }

    private static void fillMatrixB(int[][] matrix) {
        int digit = 1;

        for (int cols = 0; cols < matrix.length; cols++) {
            if (cols % 2 == 0) {
                for (int rows = 0; rows < matrix.length; rows++) {
                    matrix[rows][cols] = digit;
                    digit++;

                }

            } else {

                for (int rows = matrix.length - 1; rows >= 0 ; rows--) {
                    matrix[rows][cols] = digit;
                    digit++;
                }

            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixA(int[][] matrix) {
        int digit = 1;
        for (int cols = 0; cols < matrix.length; cols++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix [rows][cols] = digit;
                digit++;
            }
        }
    }
}
