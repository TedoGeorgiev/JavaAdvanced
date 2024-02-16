package Exams._19_Java_Advanced_Retake_Exam_16_December_2020;

import java.util.*;

public class _1_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();

        fillQueue(scanner, liquidsQueue);
        fillStack(scanner, ingredientsStack);


        //ћоже с TreeMAP но за тест с HASH и сортировка при принтирането
        Map <String, Integer> matsMap = new HashMap<>();
        matsMap.put("Bread", 0);
        matsMap.put("Cake", 0);
        matsMap.put("Fruit Pie", 0);
        matsMap.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int sum = liquid + ingredient;

            switch (sum) {

                case 25:
                    matsMap.put("Bread", matsMap.get("Bread") + 1);
                    break;

                case 50:
                    matsMap.put("Cake", matsMap.get("Cake") + 1);
                    break;

                case 75:
                    matsMap.put("Pastry", matsMap.get("Pastry") + 1);
                    break;

                case 100:
                    matsMap.put("Fruit Pie", matsMap.get("Fruit Pie") + 1);
                    break;

                default:
                    ingredientsStack.push(ingredient + 3);
                    break;
            }
        }

        int countEmpty = (int) matsMap.values()
                .stream()
                .filter(v -> v == 0)
                .count();

        if (countEmpty == 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");

        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");

        } else {
            printDeque("Liquids left: ", liquidsQueue);
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");

        } else {
            printDeque("Ingredients left: ", ingredientsStack);
        }

        matsMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }

    private static void printDeque(String str, Deque<Integer> ingredientsStack) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        ingredientsStack.forEach(i -> sb.append(i).append(", "));
        System.out.println(sb.substring(0, sb.length() - 2));
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
