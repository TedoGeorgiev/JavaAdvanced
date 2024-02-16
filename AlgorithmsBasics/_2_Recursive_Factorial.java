package AlgorithmsBasics;

import java.util.Scanner;

public class _2_Recursive_Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());

        System.out.println(calcFactorial(n));

    }
    public static long calcFactorial(long n) {

        if (n == 1) {
            return 1;
        }
        return n * calcFactorial(n - 1);
    }

}