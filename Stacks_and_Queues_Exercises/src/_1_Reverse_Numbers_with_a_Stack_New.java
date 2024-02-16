import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Reverse_Numbers_with_a_Stack_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> reverseStack = new ArrayDeque<>();
        for (int number : numbers) {
            reverseStack.push(number);
        }
        while (reverseStack.size() > 0) {
            System.out.print(reverseStack.pop() + " ");
        }

    }
}
