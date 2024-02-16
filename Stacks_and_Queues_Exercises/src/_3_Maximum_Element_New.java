import java.util.*;

public class _3_Maximum_Element_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            int [] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int command = commands[0];

            switch (command) {

                case 1:
                    int add = commands[1];
                    numbersStack.push(add);
                    break;

                case 2:
                    numbersStack.pop();
                    break;

                case 3:
                    System.out.println(Collections.max(numbersStack));
                    break;

            }
        }
    }
}
