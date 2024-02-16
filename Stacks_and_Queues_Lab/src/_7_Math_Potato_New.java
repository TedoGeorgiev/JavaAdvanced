
import java.util.PriorityQueue;
import java.util.Scanner;

public class _7_Math_Potato_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int removeIndex = Integer.parseInt(scanner.nextLine());

       PriorityQueue<String> priorityPotato = new PriorityQueue<>();

        for (String name : names) {
            priorityPotato.offer(name);
        }


        int counter = 1;
        while (priorityPotato.size() > 1) {
            for (int i = 0; i < removeIndex; i++) {

                String currentName = priorityPotato.poll();
                priorityPotato.offer(currentName);

            }
            if (isPrime(counter)) {
                System.out.println("Prime " + priorityPotato.peek());

            } else {
                System.out.println("Removed " + priorityPotato.poll());
            }
            counter++;

        }

        System.out.println("Last is " + priorityPotato.poll());

    }

    private static boolean isPrime(int counter) {
        if (counter <= 1) {
            return false;
        }
        for (int i = 2; i < counter; i++) {
            if (counter % i == 0) {
                return false;
            }
        }
        return true;
    }
}
