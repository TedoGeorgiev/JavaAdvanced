import java.util.*;

public class _2_Basic_Stack_Operations_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] commands = scanner.nextLine().split("\\s+");

        int numbersPush = Integer.parseInt(commands[0]);
        int numbersPop = Integer.parseInt(commands[1]);
        int numberCheck = Integer.parseInt(commands[2]);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> basicStack = new ArrayDeque<>();

        for (int i = 0; i < numbersPush; i++) {
            basicStack.push(numbers[i]);

        }

        for (int i = 0; i < numbersPop; i++) {
            basicStack.pop();
        }

        if (basicStack.isEmpty()) {
            System.out.println("0");

        } else {
            if (basicStack.contains(numberCheck)) {
                System.out.println("true");

            } else {
                System.out.println(Collections.min(basicStack));
            }
        }
    }
}
