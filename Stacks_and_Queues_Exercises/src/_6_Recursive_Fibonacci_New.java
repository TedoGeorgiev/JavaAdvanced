import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _6_Recursive_Fibonacci_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 2) {
            System.out.println(1);
            return;
        }

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        for (int i = 0; i < number; i++) {
            Long num1 = stack.pop();
            Long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }

        System.out.println(stack.pop());

    }
}
