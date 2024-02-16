package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _3_Intersection_of_Two_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix = readMatrix(scanner, rows, cols);
        String [][] secondMatrix = readMatrix(scanner, rows, cols);

        String [][] resultMatrix = new String [rows][cols];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int columns = 0; columns < firstMatrix[i].length; columns++) {

                if (firstMatrix[i][columns].equals(secondMatrix [i][columns])) {
                    String add = firstMatrix[i][columns];
                    resultMatrix[i][columns] = add;

                } else {
                    resultMatrix[i][columns] = "*";
                }

            }

        }

        for (int i = 0; i < resultMatrix.length; i++) {
            String[] arr = resultMatrix[i];
            System.out.println(String.join(" ", arr));
        }

    }

    private static String [][] readMatrix(Scanner scanner, int rows, int cols) {
        String [][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;

        }
        return matrix;
    }
}
