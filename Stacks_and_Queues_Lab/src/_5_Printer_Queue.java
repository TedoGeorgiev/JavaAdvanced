import java.util.ArrayDeque;
import java.util.Scanner;

public class _5_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true) {
            String files = scanner.nextLine();
            if ("print".equalsIgnoreCase(files)) {
                break;
            }

            if ("cancel".equalsIgnoreCase(files)) {
                if (queue.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.peek());
                    queue.poll();
                }

            } else {
                queue.offer(files);
            }
        }

        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
