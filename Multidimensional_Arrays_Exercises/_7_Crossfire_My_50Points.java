package Multidimensional_Arrays_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _7_Crossfire_My_50Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dimensions = readArr(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(rows, cols, matrix);

        while (true) {
            String input = scanner.nextLine();
            if ("Nuke it from orbit".equals(input)) {
                break;
            }

            int targetRow = Integer.parseInt(input.split("\\s+")[0]);
            int targetCol = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);


            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

        }

        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                int currentElement = matrix.get(row).get(col);
                if (currentElement == 0) {
                    matrix.get(row).remove(col);
                    col--;
                }
            }
            if (matrix.get(row).size() == 0) {
                matrix.remove(row);
                row--;
            }
        }


        printMatrix(matrix);


    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(int rows, int cols, List<List<Integer>> matrix) {
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            matrix.add(row);
        }

        int counter = 1;
        for (List<Integer> row : matrix) {
            for (int i = 0; i < cols; i++) {
                row.add(counter);
                counter++;
            }
        }
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
