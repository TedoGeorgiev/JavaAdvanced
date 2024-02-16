package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _5_Maximum_Sum_of_2x2_Submatrix_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] size = readArr(scanner);

        int r = size[0];
        int c = size[1];

        int[][] matrix = new int[r][c];
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = readArr(scanner);
            matrix[i] = arr;
        }

        int[][] subMatrix = new int[2][2];

        int sum;
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int first = matrix[row][col];
                int second = matrix[row][col + 1];
                int third = matrix[row + 1][col];
                int forth = matrix[row + 1][col + 1];

                sum = first + second + third + forth;
                if (sum > maxSum) {
                    maxSum = sum;
                    fillSubMatrix(subMatrix, first, second, third, forth);
                }

            }
        }

        printMatrix(subMatrix);
        System.out.println(maxSum);


    }

    private static void printMatrix(int[][] subMatrix) {
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillSubMatrix(int[][] subMatrix, int first, int second, int third, int forth) {
        subMatrix[0][0] = first;
        subMatrix[0][1] = second;
        subMatrix[1][0] = third;
        subMatrix[1][1] = forth;
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
