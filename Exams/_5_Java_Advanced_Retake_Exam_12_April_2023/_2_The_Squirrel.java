package Exams._5_Java_Advanced_Retake_Exam_12_April_2023;

import java.util.Scanner;

public class _2_The_Squirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String [] commands = scanner.nextLine().split(",\\s+");

        char[][] matrix = new char[size][size];

        fillMatrix(size, scanner, matrix);

        int [] location = getLocation(matrix);
        int currentRow = location[0];
        int currentCol = location[1];


        int hazelnutsCount = 0;
        boolean allCollected = false;
        boolean isOutside = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

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

            if (!isInside(matrix, newRow, newCol, size, size)) {
                System.out.println("The squirrel is out of the field.");
                isOutside = true;
                break;

            } else {
                char ch = matrix[newRow][newCol];
                switch (ch) {

                    case 'h':
                        hazelnutsCount++;
                        matrix[newRow][newCol] = '*';
                        break;

                    case 't':
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.println("Hazelnuts collected: " + hazelnutsCount);
                        return;

                }
                currentRow = newRow;
                currentCol = newCol;
            }


            if (hazelnutsCount == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
                allCollected = true;
                break;
            }

        }
        if (!allCollected && !isOutside) {
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.println("Hazelnuts collected: " + hazelnutsCount);

    }

    private static void fillMatrix(int r, Scanner scanner, char[][] matrix) {
        for (int rows = 0; rows < r; rows++) {
            String line = scanner.nextLine();
            matrix[rows] = line.toCharArray();
        }
    }
    private static int[] getLocation(char[][] matrix) {
        int [] location = new int[2];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == 's') {
                    location[0] = rows;
                    location[1] = cols;
                    break;
                }
            }
        }
        return location;
    }

    private static boolean isInside(char[][] matrix, int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }
}
