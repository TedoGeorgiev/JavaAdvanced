package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _1_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstMatrix = readMatrix(scanner);
        int [][] secondMatrix = readMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        if (areEqual) {

            for (int rows = 0; rows < firstMatrix.length; rows++) {


                int[] firstArr = firstMatrix[rows];
                int[] secondArr = secondMatrix[rows];


                areEqual = firstArr.length == secondArr.length;

                if (areEqual) {
                    for (int i = 0; i < firstArr.length; i++) {
                        if (firstArr[i] != secondArr[i]) {
                            areEqual = false;
                        }
                    }
                }
            }
        }

        String output;
        if (areEqual) {
            output = "equal";

        } else {
            output = "not equal";
        }

        System.out.println(output);

    }

    private static int [][] readMatrix (Scanner scanner) {
        int [] matrixSize = readArray(scanner);

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int [] arr = readArray(scanner);

            matrix[i] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
