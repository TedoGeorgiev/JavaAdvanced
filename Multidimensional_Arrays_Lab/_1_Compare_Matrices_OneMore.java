package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _1_Compare_Matrices_OneMore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = size(scanner);
        fillMatrix(scanner, firstMatrix);

        int[][] secondMatrix = size(scanner);
        fillMatrix(scanner, secondMatrix);

        if (firstMatrix.length != secondMatrix.length) {
            System.out.println("not equal");

        } else {
            if (isEqual(firstMatrix, secondMatrix)) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        }

    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                } else {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[][] size(Scanner scanner) {
        int [] size = readArr(scanner);
        int r = size[0];
        int c = size[1];
        return new int[r][c];
    }

    private static void fillMatrix(Scanner scanner, int[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            int [] arr = readArr(scanner);
            firstMatrix[i] = arr;
        }
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
