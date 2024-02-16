package _13_Java_Advanced_Retake_Exam_15_December_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> malesStack.push(e));
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e -> femalesQueue.offer(e));

        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0) {
                malesStack.pop();

            } else if (female <= 0) {
                femalesQueue.poll();

            } else {
                if (male % 25 == 0) {
                    malesStack.pop();
                    if (malesStack.size() > 1) {
                        malesStack.pop();
                    }

                } else if (female % 25 == 0) {
                    femalesQueue.poll();
                    if (femalesQueue.size() > 1) {
                        femalesQueue.poll();
                    }

                } else {
                    if (male == female) {
                        malesStack.pop();
                        femalesQueue.poll();
                        matches ++;

                    } else {
                        femalesQueue.poll();
                        malesStack.pop();
                        malesStack.push(male - 2);
                    }
                }

            }


        }
        System.out.println("Matches: " + matches);

        if (!malesStack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Males left: ");
            malesStack.forEach(e ->
                    sb.append(e + ", "));
            System.out.println(sb.substring(0, sb.length() -2));
        } else {
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Females left: ");
            femalesQueue.forEach(e ->
                    sb.append(e + ", "));
            System.out.println(sb.substring(0, sb.length() -2));
        } else {
            System.out.println("Females left: none");
        }
    }
}
