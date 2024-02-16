package Exams._17_Java_Advanced_Retake_Exam_14_April_2021;

import java.util.Scanner;

public class _2_Cooking_journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);

        int [] location = getLocation(matrix, 'S');
        int currentRow = location[0];
        int currentCol = location[1];

        int [] getPillarsLocation = getLocation(matrix, 'P');
        int firstPillarRow = getPillarsLocation[0];
        int firstPillarCol = getPillarsLocation[1];
        int secondPillarRow = getPillarsLocation[2];
        int secondPillarCol= getPillarsLocation[3];

        int price = 0;
        boolean isOut = false;
        while (price < 50) {
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
                isOut = true;
                matrix[currentRow][currentCol] = '-';
                break;

            } else {
                char ch = matrix[newRow][newCol];

                if (Character.isDigit(ch)) {
                    int clients = Integer.parseInt(String.valueOf(ch));
                    price += clients;

                } else if (ch == 'P') {
                    if (newRow == firstPillarRow) {
                        matrix[newRow][newCol] = '-';
                        newRow = secondPillarRow;
                        newCol = secondPillarCol;

                    } else {
                        matrix[newRow][newCol] = '-';
                        newRow = firstPillarRow;
                        newCol = firstPillarCol;
                    }
                }
                matrix[currentRow][currentCol] = '-';
                matrix[newRow][newCol] = 'S';
                currentRow = newRow;
                currentCol = newCol;

            }
        }

        if (isOut) {
            System.out.println("Bad news! You are out of the pastry shop.");

        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", price);

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

                } else if (counter == 1 && ch == symbol){
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
