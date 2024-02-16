package _7_Java_Advanced_Retake_Exam14_December_2022;

import java.util.*;

public class _1_Climb_The_Peaks_100Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> climbedList = new ArrayList<>();

        Deque<Integer> portionsStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

        fillStack(scanner, portionsStack);
        fillQueue(scanner, staminaQueue);

        boolean allDone = false;
        int days = 1;
        int counter = 1;
        while (days <= 7) {
            int dailyPortion = portionsStack.pop();
            int dailyStamina = staminaQueue.poll();
            int sum = dailyStamina + dailyPortion;

            switch (counter) {
                case 1:
                    if (sum >= 80) {
                        climbedList.add("Vihren");
                    } else {
                        counter--;
                    }
                    break;

                case 2:
                    if (sum >= 90) {
                        climbedList.add("Kutelo");
                    } else {
                        counter--;
                    }
                    break;

                case 3:
                    if (sum >= 100) {
                        climbedList.add("Banski Suhodol");
                    } else {
                        counter--;
                    }
                    break;

                case 4:
                    if (sum >= 60) {
                        climbedList.add("Polezhan");
                    } else {
                        counter--;
                    }
                    break;
                case 5:
                    if (sum >= 70) {
                        climbedList.add("Kamenitza");
                    } else {
                        counter--;
                    }
                    break;
            }
            days++;
            counter++;
            if (counter > 5) {
                allDone = true;
                break;
            }
        }

        if (allDone) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!climbedList.isEmpty()) {
            System.out.println("Conquered peaks:");
            climbedList.forEach(System.out::println);
        }

        scanner.close();
    }

    private static void fillQueue(Scanner scanner, Deque<Integer> queue) {
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

    }

    private static void fillStack(Scanner scanner, Deque<Integer> stack) {
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
    }
}
