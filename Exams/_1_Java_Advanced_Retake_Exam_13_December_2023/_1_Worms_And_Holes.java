package Exams._1_Java_Advanced_Retake_Exam_13_December_2023;

import java.util.*;

public class _1_Worms_And_Holes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> wormsStack = new ArrayDeque<>();
        Deque<Integer> holesQueue = new ArrayDeque<>();

        int [] worms = readArray(scanner);
        int [] holes = readArray(scanner);

        for (int j : worms) {
            wormsStack.push(j);
        }
        for (int j : holes) {
            holesQueue.offer(j);
        }

        int matchesCount = 0;
        int allWorms = wormsStack.size();
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {

            int currentWorm = wormsStack.peek();
            int currentHole = holesQueue.peek();

            if (currentWorm == currentHole) {
                wormsStack.pop();
                holesQueue.poll();
                matchesCount++;



            } else {
                wormsStack.pop();
                holesQueue.poll();
                wormsStack.push(currentWorm - 3);
                if (wormsStack.peek() <= 0) {
                    wormsStack.pop();

                }
            }

        }

        if (matchesCount > 0) {
            System.out.printf("Matches: %d%n", matchesCount);
        } else {
            System.out.printf("There are no matches.%n");
        }

        if (matchesCount == allWorms && wormsStack.isEmpty()) {
            System.out.println("Every worm found a suitable hole!");
        } else if (matchesCount != allWorms && wormsStack.isEmpty()) {
            System.out.println("Worms left: none");
        } else {
            List<Integer> wormList = new ArrayList<>();
            while (!wormsStack.isEmpty()) {
                wormList.add(wormsStack.pop());
            }
            Collections.reverse(wormList);

            System.out.print("Worms left: ");
            for (int i = 0; i < wormList.size(); i++) {
                if (i == wormList.size() -1) {
                    System.out.printf("%d", wormList.get(i));
                    break;
                }
                System.out.printf("%d, ", wormList.get(i));
            }
            System.out.println();
        }

        if (holesQueue.isEmpty()) {
            System.out.printf("Holes left: none%n");
        } else {
            List<Integer> holeList = new ArrayList<>();
            while (!holesQueue.isEmpty()) {
                holeList.add(holesQueue.poll());
            }
            Collections.reverse(holeList);
            System.out.print("Holes left: ");
            for (int i = 0; i < holeList.size(); i++) {
                if (i == holeList.size() -1) {
                    System.out.printf("%d", holeList.get(i));
                    break;
                }
                System.out.printf("%d, ", holeList.get(i));
            }
            System.out.println();
        }

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}