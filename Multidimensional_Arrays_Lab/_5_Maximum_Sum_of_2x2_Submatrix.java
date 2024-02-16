package Multidimensional_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _5_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        int [][] maxSubMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int currentElement = matrix[r][c];
                int right = matrix[r][c + 1];

                int below = matrix[r + 1][c];
                int rightBelow = matrix[r + 1][c + 1];

                int sum = currentElement + right + below + rightBelow;

                if (maxSum < sum) {
                    maxSum = sum;
                    maxSubMatrix[0][0] = currentElement;
                    maxSubMatrix[0][1] = right;
                    maxSubMatrix[1][0] = below;
                    maxSubMatrix[1][1] = rightBelow;

                }

            }
        }

        System.out.println(maxSubMatrix[0][0] + " " + maxSubMatrix[0][1]);
        System.out.println(maxSubMatrix[1][0] + " " + maxSubMatrix[1][1]);

        System.out.println(maxSum);

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
