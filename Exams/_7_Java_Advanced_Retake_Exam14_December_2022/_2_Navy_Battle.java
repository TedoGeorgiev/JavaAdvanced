package Exams._7_Java_Advanced_Retake_Exam14_December_2022;

import java.util.Scanner;

public class _2_Navy_Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);

        int[] location = getLocation(matrix);
        int currentRow = location[0];
        int currentCol = location[1];

        int mines = 0;
        int cruiser = 0;

        while (true) {

            String command = scanner.nextLine();
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

            char ch = matrix[newRow][newCol];
            switch (ch) {
                case '*':
                    mines++;
                    break;

                case 'C':
                    cruiser++;
                    break;
            }

            matrix[currentRow][currentCol] = '.';
            matrix[newRow][newCol] = 'C';
            currentRow = newRow;
            currentCol = newCol;

            if (mines == 3 || cruiser == 3) {
                break;
            }

        }

        if (mines == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);

        } else {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }

        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int r, Scanner scanner, char[][] matrix) {
        for (int rows = 0; rows < r; rows++) {
            char [] line = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[rows] = line;
        }
    }
    private static int[] getLocation(char[][] matrix) {
        int [] location = new int[2];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == 'S') {
                    location[0] = rows;
                    location[1] = cols;
                }
            }
        }
        return location;
    }

    private static boolean isInside(char[][] matrix, int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }
}

