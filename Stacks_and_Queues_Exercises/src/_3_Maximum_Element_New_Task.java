import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _3_Maximum_Element_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String [] commands = scanner.nextLine().split("\\s+");

            String command = commands[0];
            switch (command) {

                case "1":
                    int addNumber = Integer.parseInt(commands[1]);
                    numbersStack.push(addNumber);
                    break;

                case "2":
                    if (!numbersStack.isEmpty()) {
                        numbersStack.pop();
                    }
                    break;
                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;
            }

        }

    }
}
