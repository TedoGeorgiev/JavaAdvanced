package Multidimensional_Arrays_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class _6_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotate = Integer.parseInt(scanner.nextLine()
                .split("\\(")[1]
                .replaceAll("\\)", ""));

        int rotateTimes = rotate % 360 / 90;

        int maxLength = Integer.MIN_VALUE;
        List<String> elementList = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
            elementList.add(line);
        }

        int rows = elementList.size();
        int cols = maxLength;

        char [][] matrix = new char[rows][cols];

        fillMatrix(matrix, elementList);

        for (int i = 0; i < rotateTimes; i++) {
            matrix = rotateMatrix(matrix, rows, cols);
            // Swap rows and cols after each rotation
            int temp = rows;
            rows = cols;
            cols = temp;
        }

        printMatrix(matrix);

    }

    private static char [][] rotateMatrix(char[][] matrix, int rows, int cols) {
        char[][] rotatedMatrix = new char[cols][rows];

        for (int col = 0; col < cols; col++) {
            int colCounter = 0;
            for (int row = rows - 1; row >= 0 ; row--) {
                rotatedMatrix[col][colCounter++] = matrix[row][col];
            }
        }
        return rotatedMatrix;
    }


    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
        
    }

    private static void fillMatrix(char [][] matrix, List<String> elementList) {
        for (int row = 0; row < matrix.length; row++) {
            String currentWord = elementList.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < currentWord.length()) {
                    matrix[row][col] = currentWord.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }

            }
        }

    }
}
