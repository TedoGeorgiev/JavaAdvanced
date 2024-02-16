import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _5_Balanced_Parentheses_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Character> openStack = new ArrayDeque<>();
        Deque<Character> closeQueue = new ArrayDeque<>();

        String braces = scanner.nextLine();

        for (char ch : braces.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                openStack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                closeQueue.offer(ch);
            }
        }


        String result = isBalanced(openStack, closeQueue) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean isBalanced(Deque<Character> openStack, Deque<Character> closeQueue) {
        while (!openStack.isEmpty()) {
            char openBrace = openStack.pop();
            char closeBrace = ' ';
            if (!closeQueue.isEmpty()) {
                closeBrace = closeQueue.poll();
            } else {
                return false;
            }

            switch (openBrace) {
                case '(':
                    if (closeBrace != ')') {
                        return false;
                    }
                    break;

                case '{':
                    if (closeBrace != '}') {
                        return false;
                    }
                    break;

                case '[':
                    if (closeBrace != ']') {
                        return false;
                    }
                    break;
            }
        }
        return true;

    }
}


