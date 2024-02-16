package _5_Java_Advanced_Retake_Exam_12_April_2023;

import java.util.*;

public class _1_Rubber_Duck_Debuggers_100Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> ducksMap = new LinkedHashMap<>();
        ducksMap.put("Darth Vader Ducky", 0);
        ducksMap.put("Thor Ducky", 0);
        ducksMap.put("Big Blue Rubber Ducky", 0);
        ducksMap.put("Small Yellow Rubber Ducky", 0);

        Deque<Integer> timeQueue = new ArrayDeque<>();
        Deque<Integer> taskStack = new ArrayDeque<>();

        fillQueue(scanner, timeQueue);
        fillStack(scanner, taskStack);

        while (!timeQueue.isEmpty() && !taskStack.isEmpty()) {
            int time = timeQueue.poll();
            int task = taskStack.pop();
            int result = time * task;

            if (result <= 60) {
                ducksMap.put("Darth Vader Ducky", ducksMap.get("Darth Vader Ducky") + 1);

            } else if (result <= 120) {
                ducksMap.put("Thor Ducky", ducksMap.get("Thor Ducky") + 1);

            } else if (result <= 180) {
                ducksMap.put("Big Blue Rubber Ducky", ducksMap.get("Big Blue Rubber Ducky") + 1);

            } else if (result <= 240) {
                ducksMap.put("Small Yellow Rubber Ducky", ducksMap.get("Small Yellow Rubber Ducky") + 1);

            } else {
                timeQueue.offer(time);
                taskStack.push(task - 2);

            }
        }

        System.out.printf("Congratulations, all tasks have been completed! Rubber ducks rewarded:%n");
        ducksMap.forEach((K, V) -> System.out.printf("%s: %d%n", K, V));



    }



    private static void fillStack(Scanner scanner, Deque<Integer> stack) {
        int [] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : first) {
            stack.push(i);
        }
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> queue) {
        int [] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : first) {
            queue.offer(i);
        }
    }
}
