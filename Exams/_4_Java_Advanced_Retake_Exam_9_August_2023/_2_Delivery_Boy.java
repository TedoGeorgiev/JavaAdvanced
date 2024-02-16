package Exams._4_Java_Advanced_Retake_Exam_9_August_2023;

import java.util.Arrays;
import java.util.Scanner;

public class _2_Delivery_Boy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        char [][] matrix = new char[n][m];
        readMatrix(n, scanner, matrix);

        int [] location = getLocation(matrix);
        int currentRow = location[0];
        int currentCol = location[1];

        boolean isDelivered = false;

        String command = scanner.nextLine();
        while (true) {

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

            if (!isInside(matrix, newRow, newCol, n, m)) {
                System.out.println("The delivery is late. Order is canceled.");
                matrix[location[0]][location[1]] = ' ';
                break;

            } else {

                char ch = matrix[newRow][newCol];

                switch (ch) {

                    case 'A':
                        System.out.println("Pizza is delivered on time! Next order...");
                        matrix[newRow][newCol] = 'P';
                        isDelivered = true;
                        break;

                    case '*':
                        command = scanner.nextLine();
                        continue;

                    case 'B':
                        break;

                    case 'P':
                        System.out.println("Pizza is collected. 10 minutes for delivery.");
                        matrix[newRow][newCol] = 'R';
                        break;

                    default:
                        matrix[newRow][newCol] = '.';
                        break;

                }
                currentRow = newRow;
                currentCol = newCol;

            }

            if (isDelivered) {
                break;
            }

            command = scanner.nextLine();
        }


        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }


    }

    private static boolean isInside(char[][] matrix, int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }



    private static int[] getLocation(char[][] matrix) {
        int [] location = new int[2];
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == 'B') {
                    location[0] = rows;
                    location[1] = cols;
                }
            }
        }
        return location;
    }

    private static void readMatrix(int r, Scanner scanner, char[][] matrix) {
        for (int rows = 0; rows < r; rows++) {
            String line = scanner.nextLine();
            matrix[rows] = line.toCharArray();
        }
    }
}
