package Exams._3_Java_Advanced_Regular_Exam_17_June_2023;

import java.util.Arrays;
import java.util.Scanner;

public class _2_Mouse_In_The_Kitchen {
    int [] mousePosition = new int[2];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = dimensions[0];
        int c = dimensions[1];

        char[][] matrix = new char[r][c];

        for (int row = 0; row < r; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }

        int cheeseCounter = getCheeseNumber(matrix);
        int [] mousePosition = getMousePosition(matrix);
        int currentRow = mousePosition[0];
        int currentCol = mousePosition[1];

        boolean isAllEaten = false;
        boolean isOutside = false;
        boolean isTrapped = false;
        String command = scanner.nextLine();
        while (!"danger".equals(command)) {
            int oldRow = mousePosition[0];
            int oldCol = mousePosition[1];

            switch (command) {

                case "up":
                    currentRow--;
                    break;

                case "down":
                    currentRow++;
                    break;

                case "right":
                    currentCol++;
                    break;

                case "left":
                    currentCol--;
                    break;

            }

            if (!isInside(matrix, currentRow, currentCol, r, c)) {
                System.out.println("No more cheese for tonight!");
                isOutside = true;
                break;

            } else {

                if (matrix[currentRow][currentCol] == '@') {
                    currentRow = oldRow;
                    currentCol = oldCol;
                    command = scanner.nextLine();
                    continue;

                } else {
                    if (matrix[currentRow][currentCol] == 'C') {
                        cheeseCounter--;

                    }
                    if (matrix[currentRow][currentCol] == 'T') {
                        isTrapped = true;
                        System.out.println("Mouse is trapped!");
                        matrix[currentRow][currentCol] = 'M';
                        matrix[oldRow][oldCol] = '*';
                        break;
                    }

                    matrix[currentRow][currentCol] = 'M';
                    matrix[oldRow][oldCol] = '*';
                    mousePosition[0] = currentRow;
                    mousePosition[1] = currentCol;
                }
            }

            if (cheeseCounter == 0) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                isAllEaten = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (!isAllEaten && !isOutside && !isTrapped) {
            System.out.println("Mouse will come back later!");
        }

        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static boolean isInside(char[][] matrix, int newRow, int newCol, int r, int c) {
        return newRow >= 0 && newRow < r && newCol >= 0 && newCol < c;
    }

    private static int[] getMousePosition(char[][] matrix) {
        int [] mouse = new int[2];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == 'M') {
                    mouse[0] = rows;
                    mouse[1] = cols;
                }
            }
        }
        return mouse;
    }

    private static int getCheeseNumber(char[][] matrix) {
        int countCheese = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == 'C') {
                    countCheese++;
                }
            }
        }
        return countCheese;
    }
}
