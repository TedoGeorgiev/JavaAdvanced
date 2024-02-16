import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _6_Recursive_Fibonacci_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Long> fibNumber = new ArrayDeque<>();
        int number = Integer.parseInt(scanner.nextLine());

        if (number < 2) {
            System.out.println(1);
            return;
        }
        fibNumber.push(0L);
        fibNumber.push(1L);

        for (int i = 0; i < number; i++) {
            Long num1 = fibNumber.pop();
            Long num2 = fibNumber.pop();

            fibNumber.push(num1);
            fibNumber.push(num1 + num2);

        }
        System.out.println(fibNumber.pop());

    }
}