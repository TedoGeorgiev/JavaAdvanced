import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _7_Math_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> queue = new PriorityQueue<>();
        String[] players = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        for (String player : players) {
            queue.offer(player);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < n; i++) {
                String currentPlayer = queue.peek();
                queue.poll();
                queue.offer(currentPlayer);
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());

            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if (cycle % i == 0) {
                return false;
            }
        }

        return true;
    }
}