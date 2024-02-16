package Exams._11_Java_Advanced_Retake_Exam_13_April_2022;

import java.util.Scanner;

public class _2_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);

        int [] location = getLocation(matrix, 'A');
        int currentRow = location[0];
        int currentCol = location[1];

        int [] mirrorsLocation = getLocation(matrix, 'M');
        int firstMirrorRow = mirrorsLocation[0];
        int firstMirrorCol = mirrorsLocation[1];
        int secondMirrorRow = mirrorsLocation[2];
        int secondMirrorCol= mirrorsLocation[3];

        int moneySpent = 0;
        boolean isGone = false;
        while (moneySpent < 65) {

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

            if (!isInside(matrix, newRow, newCol)) {
                matrix[currentRow][currentCol] = '-';
                isGone = true;
                break;

            } else {
                char ch = matrix[newRow][newCol];

                if (Character.isDigit(ch)) {
                    int swordPrice = Integer.parseInt(String.valueOf(ch));
                    moneySpent += swordPrice;

                } else if (ch == 'M') {
                    if (newRow == firstMirrorRow) {
                        matrix[newRow][newCol] = '-';
                        newRow = secondMirrorRow;
                        newCol = secondMirrorCol;

                    } else {
                        matrix[newRow][newCol] = '-';
                        newRow = firstMirrorRow;
                        newCol = firstMirrorCol;
                    }
                }
                matrix[currentRow][currentCol] = '-';
                matrix[newRow][newCol] = 'A';
                currentRow = newRow;
                currentCol = newCol;

            }

        }

        if (isGone) {
            System.out.println("I do not need more swords!");

        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", moneySpent);
        printMatrix(matrix);

    }

    private static void printMatrix ( char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
            }
            System.out.println(sb.substring(0, sb.length()));
        }
    }

    private static void fillMatrix ( int r, Scanner scanner,char[][] matrix){
        for (int rows = 0; rows < r; rows++) {
            char[] line = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[rows] = line;
        }
    }
    private static int[] getLocation (char[][] matrix, char symbol) {
        int[] location = new int[4];
        int counter = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                char ch = matrix[rows][cols];
                if (ch == symbol && counter == 0) {
                    location[0] = rows;
                    location[1] = cols;
                    counter++;
                } else if (ch == symbol && counter == 1) {
                    location[2] = rows;
                    location[3] = cols;
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

