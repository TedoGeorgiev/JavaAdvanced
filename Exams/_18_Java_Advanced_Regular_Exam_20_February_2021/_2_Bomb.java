package Exams._18_Java_Advanced_Regular_Exam_20_February_2021;

import java.util.Scanner;

public class _2_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String [] commands = scanner.nextLine().split(",");

        char [][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);



        int [] location = getLocation(matrix, 's');
        int currentRow = location[0];
        int currentCol = location[1];

        boolean isEnd = false;

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

            if (isInside(matrix, newRow, newCol)) {

                char ch = matrix[newRow][newCol];
                if (ch == 'B') {
                    System.out.println("You found a bomb!");

                } else if (ch == 'e') {
                    isEnd = true;
                    break;
                }

                matrix[currentRow][currentCol] = '+';
                matrix[newRow][newCol] = 's';
                currentRow = newRow;
                currentCol = newCol;

            }
        }

        int bombLeft = symbolCounter(matrix, 'B');

        if (bombLeft == 0) {
            System.out.println("Congratulations! You found all bombs!");

        } else if (isEnd) {
            System.out.printf("END! %d bombs left on the field%n", bombLeft);

        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n",
                    bombLeft, currentRow, currentCol);
        }


    }

    private static int symbolCounter(char[][] matrix, char symbol) {
        int counter = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == symbol) {
                    counter++;
                }
            }
        }
        return counter;
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
