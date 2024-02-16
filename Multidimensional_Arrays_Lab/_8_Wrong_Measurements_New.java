package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _8_Wrong_Measurements_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[n][];

        fillMatrix(scanner, matrix);

        int [] check = readArr(scanner);
        int r = check[0];
        int c = check[1];
        int wrongElement = matrix[r][c];



        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                int sum = 0;

                int currentElement = matrix[row][col];

                if (currentElement == wrongElement) {

                    if (row > 0) {
                        int up = matrix[row - 1][col];
                        sum = sumElelments(wrongElement, sum, up);
                    }
                    if (row < matrix.length - 1) {
                        int down = matrix[row + 1][col];
                        sum = sumElelments(wrongElement, sum, down);
                    }
                    if (col > 0) {
                        int left = matrix[row][col - 1];
                        sum = sumElelments(wrongElement, sum, left);
                    }
                    if (col < matrix[row].length -1) {
                        int right = matrix[row][col + 1];
                        sum = sumElelments(wrongElement, sum, right);
                    }
                    System.out.print(sum + " ");

                } else {
                    System.out.print(currentElement + " ");
                }

            }
            System.out.println();
        }

    }

    private static int sumElelments(int wrongElement, int sum, int number) {
        if (number != wrongElement) {
            sum += number;
        }
        return sum;
    }


    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = readArr(scanner);
            matrix[i] = arr;
        }
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
