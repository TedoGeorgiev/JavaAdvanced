import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _4_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        int toAdd = line[0];
        int toRemove = line[1];
        int x = line[2];

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < toAdd; i++) {
            numbersQueue.offer(elements[i]);
        }

        for (int i = 0; i < toRemove; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else {
            if (numbersQueue.contains(x)) {
                System.out.println("true");
            } else {

                System.out.println(Collections.min(numbersQueue));
            }
        }
    }
}
