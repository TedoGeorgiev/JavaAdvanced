package Exams._17_Java_Advanced_Retake_Exam_14_April_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
public class _1_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> daffodilsQueue = new ArrayDeque<>();
        Deque<Integer> tulipsStack = new ArrayDeque<>();

        fillStack(scanner, tulipsStack);
        fillQueue(scanner, daffodilsQueue);


        int storedFlowers = 0;
        int bouquets = 0;
        while (!daffodilsQueue.isEmpty() && !tulipsStack.isEmpty()) {
            int daffodil = daffodilsQueue.poll();
            int tulips = tulipsStack.pop();

            int result = daffodil + tulips;

            if (result == 15) {
                bouquets++;

            } else if (result < 15) {
                storedFlowers += result;

            } else {

                while (result > 15) {
                    tulips -= 2;

                    result = tulips + daffodil;
                    if (result == 15) {
                        bouquets++;
                        break;
                    }

                    if (result < 15) {
                        storedFlowers += result;
                    }
                }
            }

        }

        bouquets += storedFlowers / 15;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);

        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquets);
        }
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> threadQueue) {
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(e -> threadQueue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> taskStack) {
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(e -> taskStack.push(e));
    }
}
