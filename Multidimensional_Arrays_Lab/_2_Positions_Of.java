package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _2_Positions_Of {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] matrixSize = readArr(scanner);

        int rows = matrixSize [0];
        int cols = matrixSize [1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int [] arr = readArr(scanner);
            matrix[i] = arr;

         }

        int findNumber = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {

            int[] checkArr = matrix[row];

            for (int i = 0; i < checkArr.length; i++) {
                if (checkArr[i] == findNumber) {
                    isFound = true;
                    System.out.println(row + " " + i);
                }

            }
        }

        if (!isFound) {
            System.out.println("not found");
        }


    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
