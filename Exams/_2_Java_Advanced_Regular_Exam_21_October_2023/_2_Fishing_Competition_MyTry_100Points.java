package Exams._2_Java_Advanced_Regular_Exam_21_October_2023;

import java.util.Scanner;

public class _2_Fishing_Competition_MyTry_100Points {
    private static int [] currentLocation = new int[2];
    private static int sum = 0;
    private static boolean isFailed = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[size][size];

        fillMatrix(size, matrix, scanner);

        getCurrentLocation(matrix);

        String command = scanner.nextLine();
        while (!"collect the nets".equals(command)) {

            //"up", "down", "left", and "right"
            int newRow = currentLocation[0];
            int newCol = currentLocation[1];

            switch (command) {

                case "up":
                    if (validLocation(newRow - 1, newCol, matrix)) {
                        newRow--;
                    } else {
                        newRow = matrix.length - 1;
                    }
                    break;

                case "down":
                    if (validLocation(newRow + 1, newCol, matrix)) {
                        newRow++;
                    } else {
                        newRow = 0;
                    }
                    break;

                case "left":
                    if (validLocation(newRow, newCol - 1, matrix)) {
                        newCol--;
                    } else {
                        newCol = matrix.length - 1;
                    }
                    break;

                case "right":
                    if (validLocation(newRow, newCol + 1, matrix)) {
                        newCol++;
                    } else {
                        newCol = 0;
                    }
                    break;

            }

            char symbol = matrix[newRow][newCol];

            if (Character.isDigit(symbol)) {
                int fish = Character.getNumericValue(symbol);
                sum += fish;

            } else if (symbol == 'W') {
                isFailed = true;
                currentLocation[0] = newRow;
                currentLocation[1] = newCol;

                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n", currentLocation[0], currentLocation[1]);

                return;
            }

            matrix[currentLocation[0]][currentLocation[1]] = '-';
            matrix[newRow][newCol] = 'S';
            getCurrentLocation(matrix);

            command = scanner.nextLine();
        }

        if (sum >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else if (!isFailed) {
            int lack = 20 - sum;
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", lack);
        }

        if (sum > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", sum);
        }

        if (!isFailed) {
            printMatrix(matrix);
        }




    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean validLocation(int newRow, int newCol, char [][] matrix) {
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length;
    }

    private static void getCurrentLocation(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                char ch = matrix[r][c];
                if (ch == 'S') {
                    currentLocation[0] = r;
                    currentLocation[1] = c;
                }
            }
        }
    }

    private static void fillMatrix(int size, char[][] matrix, Scanner scanner) {
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }
    }
}
