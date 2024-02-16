
import java.util.*;

public class _4_Basic_Queue_Operations_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> numbersQueue = new ArrayDeque<>();

        int [] tokens = readArray(scanner);

        int add = tokens[0];
        int remove = tokens[1];
        int check = tokens[2];

        int [] addNumbers = readArray(scanner);

        for (int i = 0; i < add; i++) {
            numbersQueue.offer(addNumbers[i]);
        }

        for (int i = 0; i < remove; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);

        } else {
            if (numbersQueue.contains(check)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbersQueue));
            }
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
