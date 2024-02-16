import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class _4_Matching_Brackets_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Deque<Integer> bracketsStack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '(') {
                bracketsStack.push(i);

            } else if (ch == ')'){
                int start = bracketsStack.pop();

                String brackets = line.substring(start, i + 1);
                System.out.println(brackets);

            }

        }


    }
}
