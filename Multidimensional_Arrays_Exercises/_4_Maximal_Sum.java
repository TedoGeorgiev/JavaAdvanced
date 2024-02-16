package Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _4_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] size = readArr(scanner);
        int r = size[0];
        int c = size[1];

        int[][] matrix = new int[r][c];
        fillMatrix(scanner, matrix);

        int [][] squareMatrix = new int[3][3];
        int [][] maxMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;
        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int cols = 0; cols < matrix[rows].length - 2; cols++) {
                int currentRow = rows;
                int currentCol = cols;
                int sum;
                fillSquareMatrix(matrix, squareMatrix, currentRow, currentCol);

                sum = squareMatrixSum(squareMatrix);
                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix = copyMatrix(squareMatrix);

                }

            }
        }
        System.out.println("Sum = " + maxSum);
        printMax(maxMatrix);


    }

    private static void printMax(int[][] maxMatrix) {
        for (int rows = 0; rows < maxMatrix.length; rows++) {
            for (int cols = 0; cols < maxMatrix[rows].length; cols++) {
                System.out.print(maxMatrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] copyMatrix(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    private static void fillSquareMatrix(int[][] matrix, int[][] squareMatrix, int currentRow, int currentCol) {
        squareMatrix[0][0] = matrix[currentRow][currentCol];
        squareMatrix[0][1] = matrix[currentRow][currentCol + 1];
        squareMatrix[0][2] = matrix[currentRow][currentCol + 2];
        squareMatrix[1][0] = matrix[currentRow + 1][currentCol];
        squareMatrix[1][1] = matrix[currentRow + 1][currentCol + 1];
        squareMatrix[1][2] = matrix[currentRow + 1][currentCol + 2];
        squareMatrix[2][0] = matrix[currentRow + 2][currentCol];
        squareMatrix[2][1] = matrix[currentRow + 2][currentCol + 1];
        squareMatrix[2][2] = matrix[currentRow + 2][currentCol + 2];
    }

    private static int squareMatrixSum(int[][] squareMatrix) {
        int sum = 0;
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                sum += squareMatrix[i][j];
            }
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
