package Exams._10_Java_Advanced_Regular_Exam_25_June_2022;

import java.util.Scanner;

public class _2_Sticky_Fingers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String [] commandsArr = scanner.nextLine().split(",");

        char [][] matrix = new char[size][size];
        fillMatrix(size, scanner, matrix);

        int [] location = getLocation(matrix, 'D');
        int currentRow = location[0];
        int currentCol = location[1];

        int pocket = 0;

        boolean isCaught = false;
        for (int i = 0; i < commandsArr.length; i++) {
            String command = commandsArr[i];

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
                System.out.println("You cannot leave the town, there is police outside!");

            } else {

                char ch = matrix[newRow][newCol];

                int houseMoney = 0;

                if (ch == 'P') {
                    isCaught = true;
                    matrix[newRow][newCol] = '#';
                    matrix[currentRow][currentCol] = '+';
                    break;

                } else {
                    if (ch == '$') {
                        houseMoney = newRow * newCol;
                        System.out.printf("You successfully stole %d$.%n", houseMoney);
                        pocket += houseMoney;
                    }

                    matrix[currentRow][currentCol] = '+';
                    matrix[newRow][newCol] = 'D';
                    currentRow = newRow;
                    currentCol = newCol;
                }
            }
        }

        if (isCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);

        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
        }

        printMatrix(matrix);

    }

    private static void printMatrix ( char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
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
