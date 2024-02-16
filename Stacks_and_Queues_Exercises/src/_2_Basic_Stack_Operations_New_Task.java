import java.util.*;

public class _2_Basic_Stack_Operations_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> numbersStack = new ArrayDeque<>();
        int [] array = readArray(scanner);

        int n = array[0];
        int s = array[1];
        int x = array[2];

        int [] elements = readArray(scanner);
        for (int i = 0; i < n; i++) {
            numbersStack.push(elements[i]);
        }

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);

        } else if (numbersStack.contains(x)){
            System.out.println(x);

        } else {
            System.out.println(Collections.min(numbersStack));
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
