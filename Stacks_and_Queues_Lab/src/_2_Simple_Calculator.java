import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _2_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<String> calculator = new ArrayDeque<>();

        Collections.addAll(calculator, numbers);

        int sum = Integer.parseInt(calculator.pop());
        while (calculator.size() > 0) {

            String operand = calculator.pop();
            int secondElement = Integer.parseInt(calculator.pop());

            if (operand.equals("-")) {
                sum -= secondElement;

            } else if (operand.equals("+")) {
                sum += secondElement;

            }
        }

        System.out.println(sum);

    }
}
