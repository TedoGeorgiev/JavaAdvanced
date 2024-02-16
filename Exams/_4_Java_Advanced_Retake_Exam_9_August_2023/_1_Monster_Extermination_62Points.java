package Exams._4_Java_Advanced_Retake_Exam_9_August_2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Monster_Extermination_62Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monstersQueue = new ArrayDeque<>();
        Deque<Integer> strikeStack = new ArrayDeque<>();

        fillQueue(scanner, monstersQueue);
        fillStack(scanner, strikeStack);

        int killed = 0;
        while (true) {
            if (strikeStack.isEmpty()) {
                System.out.println("The soldier has been defeated.");
                break;
            }

            int armor = monstersQueue.peek();
            int strike = strikeStack.peek();

            if (strike >= armor) {
                killed++;
                monstersQueue.poll();
                if (monstersQueue.isEmpty()) {
                    System.out.println("All monsters have been killed!");
                    break;
                }
                int remaining = strike - armor;

                if (remaining > 0) {
                    if (strikeStack.size() > 1) {
                        strikeStack.pop();
                        if (strikeStack.size() > 1) {
                            strikeStack.push(strikeStack.pop() + remaining);
                        } else {
                            strikeStack.push(remaining);
                        }
                    }
                } else {
                    strikeStack.pop();
                }

            } else {

                strikeStack.pop();
                monstersQueue.poll();
                monstersQueue.offer(armor - strike);
            }

        }

        System.out.printf("Total monsters killed: %d%n", killed);

    }

    private static void fillStack(Scanner scanner, Deque<Integer> strikeStack) {
        int [] first = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : first) {
            strikeStack.push(i);
        }
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> monstersQueue) {
        int [] first = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : first) {
            monstersQueue.offer(i);
        }
    }
}
