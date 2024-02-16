package _11_Java_Advanced_Retake_Exam_13_April_2022;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        fillQueue(scanner, steelQueue);
        fillStack(scanner, carbonStack);

        Map<String, Integer> swordsMap = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int sum = steel + carbon;

            switch (sum) {
                case 70:
                    swordsMap.putIfAbsent("Gladius", 0);
                    swordsMap.put("Gladius", swordsMap.get("Gladius") + 1);
                    break;

                case 80:
                    swordsMap.putIfAbsent("Shamshir", 0);
                    swordsMap.put("Shamshir", swordsMap.get("Shamshir") + 1);
                    break;

                case 90:
                    swordsMap.putIfAbsent("Katana", 0);
                    swordsMap.put("Katana", swordsMap.get("Katana") + 1);
                    break;

                case 110:
                    swordsMap.putIfAbsent("Sabre", 0);
                    swordsMap.put("Sabre", swordsMap.get("Sabre") + 1);
                    break;

                default:
                    carbon += 5;
                    carbonStack.push(carbon);
                    break;
            }
        }

        if (!swordsMap.isEmpty()) {
            int sum = swordsMap.values().stream().mapToInt(e -> e).sum();
            System.out.printf("You have forged %d swords.%n", sum);

        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (!steelQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Steel left: ");
            steelQueue.forEach(e -> sb.append(e).append(", "));
            System.out.println(sb.substring(0, sb.length() -2));

        } else {
            System.out.println("Steel left: none");
        }

        if (!carbonStack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Carbon left: ");
            carbonStack.forEach(e -> sb.append(e).append(", "));
            System.out.println(sb.substring(0, sb.length() -2));

        } else {
            System.out.println("Carbon left: none");
        }

        swordsMap.forEach((K, V) -> {
            System.out.printf("%s: %d%n", K, V);
        });

    }

    private static void fillQueue(Scanner scanner, Deque<Integer> queue) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> queue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> stack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> stack.push(e));
    }
}
