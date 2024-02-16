import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _5_Balanced_Parentheses_OneMore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        Deque<Character> openStack = new ArrayDeque<>();
        Deque<Character> closeQueue = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                openStack.push(ch);

            } else if (ch == ')' || ch == '}' || ch == ']'){
                closeQueue.offer(ch);
            }
        }

        if (openStack.size() != closeQueue.size()) {
            System.out.println("NO");

        } else {
            if (isBalanced(openStack, closeQueue)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static boolean isBalanced(Deque<Character> openStack, Deque<Character> closeQueue) {

        while (!openStack.isEmpty()) {
            char currentOpen = openStack.pop();
            char currentClose = closeQueue.poll();

            switch (currentOpen) {

                case '(':
                    if (currentClose != ')') {
                        return false;
                    }
                    break;

                case '{':
                    if (currentClose != '}') {
                        return false;
                    }
                    break;
                case '[':
                    if (currentClose != ']') {
                        return false;
                    }
                    break;
            }

        }
        return true;

    }
}
