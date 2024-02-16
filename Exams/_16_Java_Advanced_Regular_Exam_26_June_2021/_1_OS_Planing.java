package Exams._16_Java_Advanced_Regular_Exam_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> threadQueue = new ArrayDeque<>();
        Deque<Integer> taskStack = new ArrayDeque<>();


        fillStack(scanner, taskStack);

        fillQueue(scanner, threadQueue);

        int killTask = Integer.parseInt(scanner.nextLine());

        while (true) {
            int task = taskStack.peek();
            int thread = threadQueue.peek();
            if (task == killTask) {
                System.out.printf("Thread with value %d killed task %d%n", thread, task);
                break;
            }

            if (thread >= task) {
                taskStack.pop();
                threadQueue.poll();

            } else {
                threadQueue.poll();

            }
        }

        StringBuilder sb = new StringBuilder();
        threadQueue.stream().forEach(e -> {
            sb.append(e).append(" ");
        });

        System.out.println(sb.substring(0, sb.length() -1));
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> threadQueue) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> threadQueue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> taskStack) {
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(e -> taskStack.push(e));
    }
}
