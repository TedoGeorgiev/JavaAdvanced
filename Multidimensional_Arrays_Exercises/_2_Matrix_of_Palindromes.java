package Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _2_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = size[0];
        int c = size[1];

        String[][] matrix = new String[r][c];



        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                StringBuilder element = new StringBuilder();
                int currentRow = rows;
                int currentCol = cols;
                fillElement(element, currentRow, currentCol);
                String currentElement = element.toString();
                matrix[rows][cols] = currentElement;
            }
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static void fillElement(StringBuilder element, int currentRow, int currentCol) {

        element.append((char)('a' + currentRow));
        element.append((char)('a' + currentCol + currentRow));
        element.append((char)('a' + currentRow));

    }
}
