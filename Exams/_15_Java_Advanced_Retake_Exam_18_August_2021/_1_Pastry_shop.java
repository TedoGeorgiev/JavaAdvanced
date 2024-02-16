package _15_Java_Advanced_Retake_Exam_18_August_2021;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Pastry_shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        fillQueue(scanner, liquidsQueue);
        fillStack(scanner, ingredientsStack);

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int ingredient = ingredientsStack.pop();
            int liquid = liquidsQueue.poll();
            int result = ingredient + liquid;

            switch (result) {
                case 25:
                    foodMap.put("Biscuit", foodMap.get("Biscuit") + 1);
                    break;

                case 50:
                    foodMap.put("Cake", foodMap.get("Cake") + 1);
                    break;

                case 75:
                    foodMap.put("Pastry", foodMap.get("Pastry") + 1);
                    break;

                case 100:
                    foodMap.put("Pie", foodMap.get("Pie") + 1);
                    break;

                default:
                    ingredientsStack.push(ingredient + 3);
                    break;
            }
        }

        int size = foodMap.entrySet().stream().filter(entry ->
                entry.getValue() != 0)
                .collect(Collectors.toList())
                        .size();

        if (size == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (!liquidsQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            liquidsQueue.stream().forEach(e -> {
                sb.append(e).append(", ");
            });
            System.out.println(sb.substring(0, sb.length() - 2));

        } else {
            System.out.println("Liquids left: none");
        }

        if (!ingredientsStack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ingredients left: ");
            ingredientsStack.stream().forEach(e -> {
                sb.append(e).append(", ");
            });
            System.out.println(sb.substring(0, sb.length() - 2));
        } else {
            System.out.println("Ingredients left: none");
        }

        foodMap.entrySet().forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
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
