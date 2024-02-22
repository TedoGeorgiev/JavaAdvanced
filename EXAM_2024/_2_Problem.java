package EXAM_2024;

import java.util.Scanner;

public class _2_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        char [][] matrix = new char[size][size];
        System.out.println();
        fillMatrix(size, scanner, matrix);

        int [] location = getLocation(matrix, 'J');
        int currentRow = location[0];
        int currentCol = location[1];

        int armour = 300;
        int enemies = 4;

        while (armour > 0 && enemies > 0) {
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

            if (isInside(matrix, newRow, newCol)) {
                char ch = matrix[newRow][newCol];

                if (ch == 'E') {
                    if (enemies > 1) {
                        enemies--;
                        armour -= 100;

                    } else {
                        enemies--;
                    }

                } else if (ch == 'R') {
                    armour = 300;
                }
                matrix[currentRow][currentCol] = '-';
                matrix[newRow][newCol] = 'J';
                currentRow = newRow;
                currentCol = newCol;

            }

        }

        if (enemies == 0) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }

        if (armour == 0) {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!%n",
                    currentRow, currentCol);
        }

        printMatrix(matrix);


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
