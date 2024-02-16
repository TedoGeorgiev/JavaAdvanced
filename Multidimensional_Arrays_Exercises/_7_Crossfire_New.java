package Multidimensional_Arrays_Exercises;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class _7_Crossfire_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = readArray(scanner);

        List<List<Integer>> matrix = new ArrayList<>();
        int initRow = dimensions[0];
        int initCol = dimensions[1];

        fillMatrix(initRow, initCol, matrix);

        System.out.println();
        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {

            int [] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = tokens [0];
            int col = tokens [1];
            int radius = tokens [2];

            // триене по колона
            for (int rows = row - radius; rows <= row + radius; rows++) {
                if (isInRange(matrix, rows, col)) {
                    matrix.get(rows).set(col, 0);
                }
            }

            for (int cols = col - radius; cols <= col + radius ; cols++) {
                if (isInRange(matrix, row, cols)) {
                    matrix.get(row).set(cols, 0);
                }
            }

            for (int rows = 0; rows < matrix.size(); rows++) {
                matrix.get(rows).removeAll(List.of(0));
                if (matrix.get(rows).isEmpty()) {
                    matrix.remove(rows);
                    rows--;
                }
            }

            input = scanner.nextLine();

        }

        printMatrix(matrix);

    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
    private static boolean isInRange(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.size() && col < matrix.get(row).size();
    }


    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void fillMatrix(int row, int col, List<List<Integer>> matrix) {
        int counter = 1;
        for (int i = 0; i < row; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rowList.add(counter);
                counter++;
            }
            matrix.add(rowList);
        }
    }
}
