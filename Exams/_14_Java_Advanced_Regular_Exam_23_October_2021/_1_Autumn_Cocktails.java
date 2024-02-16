package _14_Java_Advanced_Regular_Exam_23_October_2021;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Autumn_Cocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> freshnessStack = new ArrayDeque<>();

        fillQueue(scanner, ingredientsQueue);
        fillStack(scanner, freshnessStack);

        Map<String, Integer> coctailMap = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {

            int ingredient = ingredientsQueue.poll();
            int fresh = freshnessStack.pop();
            if (ingredient <= 0) {
                freshnessStack.push(fresh);
            } else {
                int result = ingredient * fresh;

                switch (result) {
                    case 150:
                        coctailMap.putIfAbsent("Pear Sour", 0);
                        coctailMap.put("Pear Sour", coctailMap.get("Pear Sour") + 1);
                        break;

                    case 250:
                        coctailMap.putIfAbsent("The Harvest", 0);
                        coctailMap.put("The Harvest", coctailMap.get("The Harvest") + 1);
                        break;

                    case 300:
                        coctailMap.putIfAbsent("Apple Hinny", 0);
                        coctailMap.put("Apple Hinny", coctailMap.get("Apple Hinny") + 1);
                        break;

                    case 400:
                        coctailMap.putIfAbsent("High Fashion", 0);
                        coctailMap.put("High Fashion", coctailMap.get("High Fashion") + 1);
                        break;

                    default:
                        ingredientsQueue.offer(ingredient + 5);
                        break;
                }
            }
        }

        if (coctailMap.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()) {
            System.out.println("Ingredients left: " + ingredientsQueue.stream().mapToInt(Integer::intValue).sum());
//            int sum = 0;
//            for (Integer i : ingredientsQueue) {
//                sum += i;
//            }
//            System.out.println("Ingredients left: " + sum);
        }




        coctailMap.entrySet().stream().filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toList()).stream().forEach(entry -> {
                    System.out.printf(" # %s --> %d%n",entry.getKey(), entry.getValue());
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

