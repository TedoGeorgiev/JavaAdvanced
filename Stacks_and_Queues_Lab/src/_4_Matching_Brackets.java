import java.util.ArrayDeque;
import java.util.Scanner;

public class _4_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if (currentSymbol == '(') {
                stack.push(i);

            } else if (currentSymbol == ')') {
                int startIndex = stack.pop();
                String output = expression.substring(startIndex, i + 1);
                System.out.println(output);

            }
        }

    }
}
