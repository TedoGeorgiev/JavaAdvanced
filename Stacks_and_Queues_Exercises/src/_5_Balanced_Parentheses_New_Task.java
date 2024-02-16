import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _5_Balanced_Parentheses_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //{[()]}    YES
        //{[(])}    No
        //{{[[(())]]}}  Yes

        Deque<Character> openStack = new ArrayDeque<>();
        Deque<Character> closeQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        char [] braces = input.toCharArray();

        for (char ch : braces) {
            if (ch == '{' || ch == '[' || ch == '(') {
               openStack.push(ch);

            } else if (ch == '}' || ch == ']' || ch == ')') {
                closeQueue.offer(ch);
            }
        }

        if (openStack.isEmpty() && closeQueue.isEmpty()) {
            System.out.println("No");
        } else {
            if (isEqual(openStack, closeQueue)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }

    private static boolean isEqual(Deque<Character> openStack, Deque<Character> closeQueue) {

        while (!openStack.isEmpty()) {
            char open = openStack.pop();
            if (closeQueue.isEmpty()) {
                return false;
            }
            char close = closeQueue.poll();

            switch (open) {
                case '(':
                    if (close != ')') {
                        return false;
                    }
                    break;
                case '{':
                    if (close != '}') {
                        return false;
                    }
                    break;
                case '[':
                    if (close != ']') {
                        return false;
                    }
                    break;

            }

        }

        return closeQueue.isEmpty();

    }
}
