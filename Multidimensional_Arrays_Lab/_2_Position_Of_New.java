package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _2_Position_Of_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] size = readArr(scanner);

        int r = size[0];
        int c = size[1];

        int [][] matrix = new int[r][c];

        for (int row = 0; row < matrix.length; row++) {
            int [] arr = readArr(scanner);
            matrix[row] = arr;
        }

        int check = Integer.parseInt(scanner.nextLine());

        if (!isFound(matrix, check)) {
            System.out.println("not found");
        } else {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (check == matrix[row][col]) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }


    }

    private static boolean isFound(int[][] matrix, int check) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (check == matrix[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
