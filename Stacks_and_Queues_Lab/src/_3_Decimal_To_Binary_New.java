import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _3_Decimal_To_Binary_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryStack = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.println(decimal);

        } else {

            while (decimal > 0) {
                int digit = decimal % 2;
                binaryStack.push(digit);

                decimal /= 2;
            }

            while (!binaryStack.isEmpty()) {
                System.out.print(binaryStack.pop());
            }

        }
    }
}
