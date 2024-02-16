package _10_Java_Advanced_Regular_Exam_25_June_2022;

import java.util.*;

public class _1_Its_Chocolate_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack = new ArrayDeque<>();

        fillQueue(scanner, milkQueue);
        fillStack(scanner, cacaoStack);

        Map<String, Integer> chocoMap = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {

            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();
            double cacaoPercent = cacao / (milk + cacao) * 100;

            switch ((int)cacaoPercent) {
                case 30:
                    chocoMap.putIfAbsent("Milk Chocolate", 0);
                    chocoMap.put("Milk Chocolate", chocoMap.get("Milk Chocolate") + 1);
                    break;

                case 50:
                    chocoMap.putIfAbsent("Dark Chocolate", 0);
                    chocoMap.put("Dark Chocolate", chocoMap.get("Dark Chocolate") + 1);
                    break;

                case 100:
                    chocoMap.putIfAbsent("Baking Chocolate", 0);
                    chocoMap.put("Baking Chocolate", chocoMap.get("Baking Chocolate") + 1);
                    break;

                default:
                    milk += 10;
                    milkQueue.offer(milk);
                    break;
            }

        }

        if (chocoMap.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (!chocoMap.isEmpty()) {
            chocoMap.forEach((K, V) -> System.out.printf("# %s --> %d%n", K, V));
        }

    }


    private static void fillQueue(Scanner scanner, Deque<Double> queue) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> queue.offer(e));
    }

    private static void fillStack(Scanner scanner, Deque<Double> stack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(e -> stack.push(e));
    }
}
