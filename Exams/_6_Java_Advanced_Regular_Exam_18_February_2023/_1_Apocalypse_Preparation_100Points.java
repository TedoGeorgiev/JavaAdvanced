package _6_Java_Advanced_Regular_Exam_18_February_2023;

import java.util.*;
import java.util.stream.Collectors;

public class _1_Apocalypse_Preparation_100Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> healMap = new TreeMap<>();
        Deque<Integer> textileQueue = new ArrayDeque<>();
        Deque<Integer> medicamentStack = new ArrayDeque<>();

        fillQueue(scanner, textileQueue);
        fillStack(scanner, medicamentStack);

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int textile = textileQueue.poll();
            int medicament = medicamentStack.pop();

            int sum = textile + medicament;

            switch (sum) {
                case 30:
                    healMap.putIfAbsent("Patch", 0);
                    healMap.put("Patch", healMap.get("Patch") + 1);
                    break;
                case 40:
                    healMap.putIfAbsent("Bandage", 0);
                    healMap.put("Bandage", healMap.get("Bandage") + 1);
                    break;
                case 100:
                    healMap.putIfAbsent("MedKit", 0);
                    healMap.put("MedKit", healMap.get("MedKit") + 1);
                    break;

                default:
                    if (sum > 100) {
                        healMap.putIfAbsent("MedKit", 0);
                        healMap.put("MedKit", healMap.get("MedKit") + 1);

                        int remaining = sum - 100;
                        int nextMedicament = medicamentStack.pop();
                        medicamentStack.push(nextMedicament + remaining);
                    } else {
                        medicamentStack.push(medicament + 10);

                    }
                    break;

            }
        }

        if (textileQueue.isEmpty() && medicamentStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        } else {
            if (textileQueue.isEmpty()) {
                System.out.println("Textiles are empty.");
            } else {
            System.out.println("Medicaments are empty.");
            }
        }

        List<Map.Entry<String, Integer>> toSort = sortByValue(healMap);
        printMap(toSort);

        if (!textileQueue.isEmpty()) {
            System.out.println("Textiles left: " + printWithDelimiter(textileQueue));

        } else if (!medicamentStack.isEmpty()) {
            System.out.println("Medicaments left: " + printWithDelimiter(medicamentStack));
        }

        scanner.close();
    }

    private static String printWithDelimiter(Deque<Integer> medicamentStack) {
        return medicamentStack.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    private static void printMap(List<Map.Entry<String, Integer>> toSort) {
        for (Map.Entry<String, Integer> entry : toSort) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> healMap) {
        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : healMap.entrySet()) {
            toSort.add(entry);
        }

        toSort.sort(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)));
        return toSort;
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
