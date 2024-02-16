import java.util.ArrayDeque;
import java.util.Scanner;

public class _3_Decimal_To_Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

//        System.out.println(Integer.toBinaryString(number));
        ArrayDeque<Integer> binaryDeck = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(number);

        } else {
            while (number > 0) {
                int binary = number % 2;
                binaryDeck.push(binary);
                number /= 2;

            }

        }

        while (!binaryDeck.isEmpty()) {
            System.out.print(binaryDeck.pop());
        }

    }
}
