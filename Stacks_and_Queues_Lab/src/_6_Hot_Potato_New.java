import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _6_Hot_Potato_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int removeIndex = Integer.parseInt(scanner.nextLine());

        Deque<String> potatoQueue = new ArrayDeque<>();
        for (String name : names) {
            potatoQueue.offer(name);
        }

        while (potatoQueue.size() > 1) {

            for (int i = 1; i < removeIndex; i++) {

                String currentName = potatoQueue.peek();
                potatoQueue.poll();
                potatoQueue.offer(currentName);
            }
            System.out.println("Removed " + potatoQueue.poll());

        }

        System.out.println("Last is " + potatoQueue.poll());
    }
}
