package _8_Java_Advanced_Regular_Exam_22_October_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Energy_Drinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> drinksQueue = new ArrayDeque<>();

        fillStack(scanner, caffeineStack);
        fillQueue(scanner, drinksQueue);

        int maxCaffeine = 300;
        int caffeineDrunk = 0;
         while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()) {
             int caffeine = caffeineStack.pop();
             int drink = drinksQueue.poll();
             int result = caffeine * drink;

             if (result <= maxCaffeine) {
                 maxCaffeine -= result;
                 caffeineDrunk += result;

             } else {
                 drinksQueue.offer(drink);
                 maxCaffeine += 30;
                 if (maxCaffeine > 300) {
                     maxCaffeine = 300;
                 }
                 caffeineDrunk -= 30;
                 if (caffeineDrunk < 0) {
                     caffeineDrunk = 0;
                 }
             }
         }

         if (!drinksQueue.isEmpty()) {
             StringBuilder sb = new StringBuilder();
             sb.append("Drinks left: ");
             drinksQueue.forEach(e -> {
                 sb.append(e + ", ");
             });
             System.out.println(sb.substring(0, sb.length() -2));

         } else {
             System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
         }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", caffeineDrunk);
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> queue) {
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(e -> queue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> stack) {
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(e -> stack.push(e));
    }
}
