
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        PriorityQueue<String> queue = new PriorityQueue<>();
        String[] players = scanner.nextLine().split("\\s+");


        for (String player : players) {
            queue.offer(player);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        System.out.println();
    }
}