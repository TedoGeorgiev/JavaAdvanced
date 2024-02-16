import java.util.*;

public class _4_Basic_Queue_Operations_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] commands = readArr(scanner);

        int add = commands[0];
        int remove = commands[1];
        int check = commands[2];

        int [] numbers = readArr(scanner);

        Deque<Integer> numbersQueue = new ArrayDeque<>();
        for (int i = 0; i < add; i++) {
            numbersQueue.offer(numbers[i]);
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

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
