package Exams._3_Java_Advanced_Regular_Exam_17_June_2023;

import java.util.*;

public class _1_Temple_of_Doom {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = new ArrayDeque<>();
        Deque<Integer> substanceStack = new ArrayDeque<>();
        Set<Integer> challengeSet = new LinkedHashSet<>();

        fillQueue(scanner, toolsQueue);
        fillStack(scanner, substanceStack);
        fillSet(scanner, challengeSet);

        while (!toolsQueue.isEmpty()) {

            int currentTool = toolsQueue.poll();
            int currentSubstance = substanceStack.pop();

            int result = currentTool * currentSubstance;

            if (!challengeSet.contains(result)) {
                currentTool++;
                toolsQueue.offer(currentTool);
                currentSubstance--;
                substanceStack.push(currentSubstance);
                if (substanceStack.peek() == 0) {
                    substanceStack.pop();
                }

            } else {
                challengeSet.remove(result);
            }
            if (challengeSet.isEmpty()) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                break;
            }
            if (substanceStack.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                break;
            }
        }


        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: ");
            printCollection(toolsQueue);
        }

        if (!substanceStack.isEmpty()) {
            System.out.print("Substances: ");
            printCollection(substanceStack);
        }

        if (!challengeSet.isEmpty()) {
            StringBuilder printAll = new StringBuilder();
            challengeSet.forEach(e -> printAll.append(e).append(", "));
            System.out.printf("Challenges: %s", printAll.substring(0, printAll.length() - 2)); // Remove the last comma and space
        }

    }

    private static void printCollection(Deque<Integer> deque) {
        StringBuilder printAll = new StringBuilder();
        deque.forEach(e -> printAll.append(e).append(", "));
        System.out.println(printAll.substring(0, printAll.length() - 2)); // Remove the last comma and space
    }

    private static void fillSet(Scanner scanner, Set<Integer> challengeSet) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> challengeSet.add(e));
    }

    private static void fillStack(Scanner scanner, Deque<Integer> substanceStack) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> substanceStack.push(e));
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> toolsQueue) {
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> toolsQueue.offer(e));
    }
}
