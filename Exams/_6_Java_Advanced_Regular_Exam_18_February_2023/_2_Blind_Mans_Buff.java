package Exams._6_Java_Advanced_Regular_Exam_18_February_2023;

import java.util.Scanner;

public class _2_Blind_Mans_Buff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        int N = Integer.parseInt(line.split("\\s+")[0]);
        int M = Integer.parseInt(line.split("\\s+")[1]);

        char[][] matrix = new char[N][M];

        fillMatrix(N, scanner, matrix);

        int [] location = getLocation(matrix);
        int currentRow = location[0];
        int currentCol = location[1];

        int countPlayers = 0;
        int moves = 0;
        String command = scanner.nextLine();
        while (!"Finish".equals(command)) {

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

            if (isInside(matrix, newRow, newCol, N, M) && matrix[newRow][newCol] != 'O') {
                char ch = matrix[newRow][newCol];
                switch (ch) {

                    case 'P':
                        countPlayers++;
                        moves++;
                        matrix[newRow][newCol] = '-';
                        break;

                    case '-':
                    case 'B':
                        moves++;
                        break;
                }

                currentRow = newRow;
                currentCol = newCol;
            }

            if (countPlayers == 3) {
                break;
            }

            command = scanner.nextLine();
        }


        System.out.println("Game over!");
        System.out.print("Touched opponents: " + countPlayers + " ");
        System.out.print("Moves made: " + moves);
        System.out.println();
    }

        private static void fillMatrix(int r, Scanner scanner, char[][] matrix) {
            for (int rows = 0; rows < r; rows++) {
                char [] line = scanner.nextLine().replaceAll(" ", "").toCharArray();
                matrix[rows] = line;
            }
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

        private static boolean isInside(char[][] matrix, int newRow, int newCol, int n, int m) {
            return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
        }
    }