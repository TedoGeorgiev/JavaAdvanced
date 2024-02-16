import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
public class _1_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

//        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(e -> Integer.parseInt(e))
//                .toArray();
//
//        for (int number : numbers) {
//            numbersStack.push(number);
//        }

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(numbersStack::push);

        while (!numbersStack.isEmpty()) {
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
