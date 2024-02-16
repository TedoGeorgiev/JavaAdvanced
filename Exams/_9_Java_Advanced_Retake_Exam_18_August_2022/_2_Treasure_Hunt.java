package Exams._9_Java_Advanced_Retake_Exam_18_August_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _2_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = dimensions[0];
        int c = dimensions[1];

        char [][] matrix = new char[r][c];
        fillMatrix(r, scanner, matrix);

        int [] location = getLocation(matrix, 'Y');
        int currentRow = location[0];
        int currentCol = location[1];

        List<String> commandList = new ArrayList<>();

        String command = scanner.nextLine();
        while (!"Finish".equals(command)) {

            int newRow = currentRow;
            int newCol = currentCol;

            switch (command) {

                case "up":
                    newRow--;
                    break;

                case "down":
                    newRow++;
                    break;

                case "right":
                    newCol++;
                    break;

                case "left":
                    newCol--;
                    break;
            }


            if (isInside(matrix, newRow, newCol)) {
                char ch = matrix[newRow][newCol];

                if (ch != 'T') {
                    commandList.add(command);
                    currentRow = newRow;
                    currentCol = newCol;
                }
            }


            command = scanner.nextLine();
        }

        if (matrix[currentRow][currentCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ",commandList));

        } else {
            System.out.println("The map is fake!");
        }
    }
    private static void printMatrix ( char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix ( int r, Scanner scanner,char[][] matrix){
        for (int rows = 0; rows < r; rows++) {
            char[] line = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[rows] = line;
        }
    }
    private static int[] getLocation (char[][] matrix, char symbol) {
        int[] location = new int[2];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == symbol) {
                    location[0] = rows;
                    location[1] = cols;
                    break;
                }
            }
        }
        return location;
    }

    private static boolean isInside ( char[][] matrix, int newRow, int newCol){
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[newRow].length;
    }
}
