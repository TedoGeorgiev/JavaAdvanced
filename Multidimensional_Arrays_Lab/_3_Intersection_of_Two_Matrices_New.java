package Multidimensional_Arrays_Lab;

import java.util.Scanner;

public class _3_Intersection_of_Two_Matrices_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] firstMatrix = new char[rows][cols];
        char [][] secondMatrix = new char[rows][cols];
        readMatrix(scanner, firstMatrix);
        readMatrix(scanner, secondMatrix);

        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                char firstMatrixChar = firstMatrix[r][c];
                char secondMatrixChar = secondMatrix[r][c];
                if (firstMatrixChar == secondMatrixChar) {
                    System.out.print(firstMatrixChar);

                } else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }


    }

    private static void readMatrix(Scanner scanner, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String arr = scanner.nextLine();
            char [] charArr = arr.toCharArray();
            matrix[i] = charArr;

        }
    }
}
