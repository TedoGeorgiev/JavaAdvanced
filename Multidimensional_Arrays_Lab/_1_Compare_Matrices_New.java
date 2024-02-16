package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _1_Compare_Matrices_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = true;

        if (firstMatrix.length != secondMatrix.length) {
            areEqual = false;

        } else {

            for (int i = 0; i < firstMatrix.length; i++) {

                int[] firstArr = firstMatrix[i];
                int[] secondArr = secondMatrix[i];


                if (firstArr.length != secondArr.length) {
                    areEqual = false;
                    break;

                } else {
                    for (int row = 0; row < firstArr.length; row++) {
                        if (firstArr[row] != secondArr[row]) {
                            areEqual = false;
                            break;

                        }
                    }
                }
            }
        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] matrixSize = readArr(scanner);

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = readArr(scanner);
            matrix[i] = arr;

        }
        return matrix;
    }

    private static int[] readArr(Scanner scanner) {
        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return arr;
    }
}
