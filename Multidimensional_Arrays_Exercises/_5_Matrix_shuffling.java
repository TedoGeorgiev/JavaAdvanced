package Multidimensional_Arrays_Exercises;

import java.util.Scanner;

public class _5_Matrix_shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] size = readArr(scanner);
        int r = Integer.parseInt(size[0]);
        int c = Integer.parseInt(size[1]);
        String [][] matrix = new String[r][c];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArr(scanner);
        }

        while (true) {
            String input = scanner.nextLine();
            if ("END".equals(input)) {
                break;
            }

            if (!areCommandsValid(input, matrix)) {
                System.out.println("Invalid input!");
            } else {
                String command = input.split("\\s+")[0];
                int row1 = Integer.parseInt(input.split("\\s+")[1]);
                int col1 = Integer.parseInt(input.split("\\s+")[2]);
                int row2 = Integer.parseInt(input.split("\\s+")[3]);
                int col2 = Integer.parseInt(input.split("\\s+")[4]);


                String currentElement = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = currentElement;

                printMatrix(matrix);
            }



        }


    }

    private static boolean areCommandsValid(String input, String [][] matrix) {
        String [] commands = input.split("\\s+");
        if (commands.length != 5) {
            return false;
        }
        if (!"swap".equals(commands[0])) {
            return false;
        }
        int row1 = Integer.parseInt(commands[1]);
        int col1 = Integer.parseInt(commands[1]);
        int row2 = Integer.parseInt(commands[1]);
        int col2 = Integer.parseInt(commands[1]);

        return (row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length &&
                col1 >= 0 && col1 < matrix.length && col2 >= 0 && col2 < matrix.length);


    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static String[] readArr(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
