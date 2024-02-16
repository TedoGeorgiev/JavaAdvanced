import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _5_Printer_Queue_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> printQueue = new ArrayDeque<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("print")) {
                break;
            }

            if (line.equals("cancel")) {
                if (!printQueue.isEmpty()) {
                    System.out.println("Canceled " + printQueue.poll());

                } else {
                    System.out.println("Printer is on standby");
                }

            } else {
                printQueue.offer(line);
            }

        }

        while (!printQueue.isEmpty()) {
            System.out.println(printQueue.poll());
        }
    }
}
