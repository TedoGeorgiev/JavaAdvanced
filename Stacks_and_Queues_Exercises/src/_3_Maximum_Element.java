import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _3_Maximum_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();


        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String command = line[0];

            switch (command) {

                case "1":
                    int number = Integer.parseInt(line[1]);
                    numbers.push(number);

                    break;

                case "2":
                    numbers.pop();

                    break;

                case "3":
                    System.out.println(Collections.max(numbers));

                    break;

            }
        }
    }
}
