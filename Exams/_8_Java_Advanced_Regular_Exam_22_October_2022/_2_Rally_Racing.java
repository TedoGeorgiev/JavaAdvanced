package Exams._8_Java_Advanced_Regular_Exam_22_October_2022;

import java.util.Scanner;

public class _2_Rally_Racing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());

        String carNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);

        int[] tunnelsLocation = getLocation(matrix);
        int firstTunnelRow = tunnelsLocation[0];
        int firstTunnelCol = tunnelsLocation[1];
        int secondTunnelRow = tunnelsLocation[2];
        int secondTunnelCol = tunnelsLocation[3];

        int currentRow = 0;
        int currentCol = 0;

        int distance = 0;
        matrix[0][0] = 'C';
        boolean isFinish = false;

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
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

            if (isInside(matrix, newRow, newCol, size, size)) {

                char ch = matrix[newRow][newCol];
                switch (ch) {

                    case 'T':
                        distance += 20;
                        if (newRow == firstTunnelRow) {
                            matrix[newRow][newCol] = '.';
                            newRow = secondTunnelRow;
                            newCol = secondTunnelCol;

                        } else {
                            matrix[newRow][newCol] = '.';
                            newRow = firstTunnelRow;
                            newCol = firstTunnelCol;
                        }
                        break;

                    case 'F':
                        isFinish = true;
                        break;

                }

                distance += 10;
                matrix[currentRow][currentCol] = '.';
                matrix[newRow][newCol] = 'C';
                currentRow = newRow;
                currentCol = newCol;
            }

            if (isFinish) {
                break;
            }

            command = scanner.nextLine();
        }

        if (isFinish) {
            System.out.printf("Racing car %s finished the stage!%n", carNumber);

        } else {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", distance);


        printMatrix(matrix);
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
        private static int[] getLocation ( char[][] matrix){
            int[] location = new int[4];
            int counter = 0;
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    char ch = matrix[rows][cols];
                    if (ch == 'T' && counter == 0) {
                        location[0] = rows;
                        location[1] = cols;
                        counter++;
                    } else if (ch == 'T' && counter == 1) {
                        location[2] = rows;
                        location[3] = cols;
                    }
                }
            }
            return location;
        }

        private static boolean isInside ( char[][] matrix, int newRow, int newCol, int n, int m){
            return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
        }
    }
