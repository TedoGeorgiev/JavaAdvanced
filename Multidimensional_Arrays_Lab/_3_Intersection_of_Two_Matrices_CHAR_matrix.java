package Multidimensional_Arrays_Lab;

import java.util.Scanner;

public class _3_Intersection_of_Two_Matrices_CHAR_matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ","");
            firstMatrix[row] = line.toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine().replaceAll(" ","");
            secondMatrix[row] = line.toCharArray();
        }

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                char outputSymbol = '*';
                if (firstMatrix[r][c] == secondMatrix[r][c]) {
                    outputSymbol = firstMatrix[r][c];
                }

                System.out.print(outputSymbol + " ");
            }
            System.out.println();
        }


    }
}
