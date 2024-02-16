package Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _8_The_Heigan_Dance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] matrix = new int[15][15];

        for (int[] row : matrix) {
            Arrays.fill(row, 1);
        }
        matrix[7][7] = 5;
        int playerRow = 7;
        int playerCol = 7;

        double heigan = 3_000_000;
        double player = 18_500;

        boolean isPoison = false;
        double dmgTurn = Double.parseDouble(scanner.nextLine());

        String lastSpell = "";
        while (heigan > 0 && player > 0) {

            String[] commands = scanner.nextLine().split("\\s+");
            heigan -= dmgTurn;

            if (isPoison) {
                player -= 3500;
                if (player < 0) {
                    break;
                }
            }

            String command = commands[0];

            int targetRow = Integer.parseInt(commands[1]);
            int targetCol = Integer.parseInt(commands[2]);

            isPoison = false;
            switch (command) {

                case "Cloud":
                    if (heigan > 0) {
                        lastSpell = "Plague Cloud";
                        if (isFound(matrix, targetRow, targetCol)) {
                            bombEffect(matrix, targetRow, targetCol);
                            if (!playerTryToMove(matrix, playerRow, playerCol)) {
                                player -= 3500;
                                isPoison = true;
                            }
                            refillMatrix(matrix);
                        }
                    }
                    break;

                case "Eruption":
                    if (heigan >0) {
                        lastSpell = "Eruption";
                        if (isFound(matrix, targetRow, targetCol)) {
                            bombEffect(matrix, targetRow, targetCol);
                            if (!playerTryToMove(matrix, playerRow, playerCol)) {
                                player -= 6000;
                            }
                            refillMatrix(matrix);
                        }
                    }
                    break;
            }

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 5) {
                        playerRow = row;
                        playerCol = col;
                    }
                }
            }
        }

        if (heigan <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %.0f%n",  player);
            printLastPosition(matrix);
        }
        if (player <= 0) {
            System.out.printf("Heigan: %.2f%n", heigan);
            System.out.println("Player: Killed by " + lastSpell);
            printLastPosition(matrix);

        }

    }

    private static void printLastPosition(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 5) {
                    System.out.println("Final position: " + row + ", " + col);
                }
            }
        }
    }

    private static void refillMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col = 0; col < row.length; col++) {
                if (row[col] != 5) {
                    row[col] = 1;
                }
            }
        }
    }

    private static boolean playerTryToMove(int[][] matrix, int playerRow, int playerCol) {

        if (playerRow > 0 && playerRow < 14 && playerCol > 0 && playerCol < 14) {
            int up = matrix[playerRow - 1][playerCol];
            int right = matrix[playerRow][playerCol + 1];
            int down = matrix[playerRow + 1][playerCol];
            int left = matrix[playerRow][playerCol - 1];


            if (up != 0) {
                matrix[playerRow - 1][playerCol] = 5;
                matrix[playerRow][playerCol] = 0;
                return true;
            } else if (right != 0) {
                matrix[playerRow][playerCol + 1] = 5;
                matrix[playerRow][playerCol] = 0;
                return true;
            } else if (down != 0) {
                matrix[playerRow + 1][playerCol] = 5;
                matrix[playerRow][playerCol] = 0;
                return true;
            } else if (left != 0) {
                matrix[playerRow][playerCol - 1] = 5;
                matrix[playerRow][playerCol] = 0;
                return true;
            }
        }

        return false;
    }


    private static void bombEffect(int[][] matrix, int targetRow, int targetCol) {
        if (targetRow > 0 && targetRow < 14 && targetCol > 0 && targetCol < 14) {
            for (int row = targetRow - 1; row <= targetRow + 1; row++) {
                if (isInRange(matrix, row, targetCol)) {
                    if (matrix[row][targetCol] != 5) {
                        matrix[row][targetCol] = 0;
                    }
                }
            }
            for (int row = targetRow - 1; row <= targetRow + 1; row++) {
                if (isInRange(matrix, row, targetCol)) {
                    if (matrix[row][targetCol - 1] != 5) {
                        matrix[row][targetCol - 1] = 0;
                    }
                }
            }
            for (int row = targetRow - 1; row <= targetRow + 1; row++) {
                if (isInRange(matrix, row, targetCol)) {
                    if (matrix[row][targetCol + 1] != 5) {
                        matrix[row][targetCol + 1] = 0;
                    }
                }
            }
        }
    }

    private static boolean isInRange(int[][] matrix, int row, int targetCol) {
        return row >= 0 && row < matrix.length && targetCol >= 0 && targetCol < matrix[row].length;
    }

    private static boolean isFound(int[][] matrix, int targetRow, int targetCol) {
        for (int row = targetRow - 1; row <= targetRow + 1; row++) {
            if(isInRange(matrix, row, targetCol)) {
                if (matrix[row][targetCol] == 5) {
                    return true;
                }
            }
        }
        for (int row = targetRow - 1; row <= targetRow + 1; row++) {
            if(isInRange(matrix, row, targetCol - 1)) {
                if (matrix[row][targetCol - 1] == 5) {
                    return true;
                }
            }
        }
        for (int row = targetRow - 1; row <= targetRow + 1; row++) {
            if(isInRange(matrix, row, targetCol + 1)) {
                if (matrix[row][targetCol + 1] == 5) {
                    return true;
                }
            }
        }
        return false;
    }
}
