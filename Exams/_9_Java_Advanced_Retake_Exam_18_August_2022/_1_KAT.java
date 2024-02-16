package _9_Java_Advanced_Retake_Exam_18_August_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;


public class _1_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> platesQueue = new ArrayDeque<>();
        Deque<Integer> carsStack = new ArrayDeque<>();

        fillQueue(scanner, platesQueue);
        fillStack(scanner, carsStack);

        int days = 0;
        int carsRegistered = 0;
        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;
            int plates = platesQueue.poll();
            int cars = carsStack.pop();
            int neededPlates = cars * 2;

            if (plates - neededPlates > 0) {
                platesQueue.offer(plates - neededPlates);
                carsRegistered += cars;

            } else if (plates - neededPlates < 0) {
               int registered = plates / 2;
               carsRegistered +=registered;
               carsStack.addLast(cars - registered);
            } else {
                carsRegistered += cars;
            }


        }

        System.out.printf("%d cars were registered for %d days!%n", carsRegistered, days);
        if (platesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");

        } else {
            if (!platesQueue.isEmpty()) {
                int sum = 0;
                for (Integer plate : platesQueue) {
                    sum += plate;
                }
                System.out.printf("%d license plates remain!%n", sum);
            }

            if (!carsStack.isEmpty()) {
                int sum = 0;
                for (Integer car : carsStack) {
                    sum += car;
                }
                System.out.printf("%d cars remain without license plates!%n", sum);
            }
        }

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
