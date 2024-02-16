import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Reverse_Numbers_with_a_Stack_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> numbersStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numbersStack::push);

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
