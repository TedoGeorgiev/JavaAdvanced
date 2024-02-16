import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _2_Simple_Calculator_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");

        Deque<String> calculatorQueue = new ArrayDeque<>();

        for (String s : input) {
            calculatorQueue.offer(s);
        }

        int sum = Integer.parseInt(calculatorQueue.poll());
        while (calculatorQueue.size() > 0) {

            String operand = calculatorQueue.poll();
            int secondElement = Integer.parseInt(calculatorQueue.poll());

            if (operand.equals("-")) {
                sum -= secondElement;

            } else if (operand.equals("+")) {
                sum += secondElement;

            }
        }

        System.out.println(sum);


    }
}
