package Exams._18_Java_Advanced_Regular_Exam_20_February_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Magic_Box {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> firstBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();

        fillQueue(scanner, firstBoxQueue);
        fillStack(scanner, secondBoxStack);

        int result = 0;
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int first = firstBoxQueue.peek();
            int second = secondBoxStack.peek();

            int sum = first + second;

            if (sum % 2 == 0) {
                result += sum;
                firstBoxQueue.poll();
                secondBoxStack.pop();

            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(second);
            }

        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }

        if (result >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", result);

        } else {
            System.out.printf("Poor prey... Value: %d%n", result);
        }




    }

    private static void fillQueue(Scanner scanner, Deque<Integer> threadQueue) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> threadQueue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> taskStack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> taskStack.push(e));
    }
}
