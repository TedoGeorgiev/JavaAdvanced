package Multidimensional_Arrays_Lab;

import java.util.Scanner;

public class _7_Find_The_Real_Queen_Not_Working {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
        }

        for (int rows = 0; rows < 8; rows++) {
            for (int cols = 0; cols < 8; cols++) {
                char currentChar = matrix[rows][cols];

                if (currentChar == 'q') {
                    int currentRow = rows;
                    int currentCol= cols;
                    if (isValidPosition(matrix, currentRow, currentCol)) {
                        System.out.print(currentRow + " " + currentCol);
                    }
                }

            }
        }
    }

    private static boolean isValidPosition(char[][] matrix, int currentRow, int currentCol) {
        int counter = 0;
        for (int cols = 0; cols < matrix[currentRow].length; cols++) {
            char ch = matrix[currentRow][cols];
            if (ch == 'q') {
                counter++;
            }
        }
        for (int rows = 0; rows < matrix.length; rows++) {
            char ch = matrix[rows][currentCol];
            if (ch == 'q') {
                counter++;
            }
        }


        /*while (currentRow > 1 && currentCol > 1) {
            char ch = matrix[currentRow - 1][currentCol - 1];
            if (ch == 'q') {
                counter++;
            }
            currentRow--;
            currentCol--;
        }

        while (currentRow < 7 && currentCol < 7) {
            char ch = matrix[currentRow + 1][currentCol + 1];
            if (ch == 'q') {
                counter++;
            }
            currentRow++;
            currentCol++;
        }

        while (currentRow > 1 && currentCol < 7) {
            char ch = matrix[currentRow - 1][currentCol +1];
            if (ch == 'q') {
                counter++;
            }
            currentRow--;
            currentCol++;
        }

        while (currentRow < 7 && currentCol > 1) {
            char ch = matrix[currentRow + 1][currentCol - 1];
            if (ch == 'q') {
                counter++;
            }
            currentRow++;
            currentCol--;
        }
*/

        return counter == 2;
    }
}