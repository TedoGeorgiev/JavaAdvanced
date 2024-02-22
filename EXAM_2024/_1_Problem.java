package EXAM_2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _1_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> foodsQueue = new ArrayDeque<>();

        fillStack(scanner, moneyStack);
        fillQueue(scanner, foodsQueue);


        int boughtFood = 0;

        while (!moneyStack.isEmpty() && !foodsQueue.isEmpty()) {

            int money = moneyStack.peek();
            int food = foodsQueue.peek();

            if (money > food) {
                boughtFood++;
                int difference = money - food;
                moneyStack.pop();
                foodsQueue.poll();
                if (moneyStack.isEmpty()) {
                    moneyStack.push(difference);

                } else {
                    int nextMoney = moneyStack.pop();
                    moneyStack.push(difference + nextMoney);
                }

            } else if (money == food) {
                boughtFood++;
                moneyStack.pop();
                foodsQueue.poll();

            } else {
                moneyStack.pop();
                foodsQueue.poll();
            }

        }

        if (boughtFood >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.%n", boughtFood);

        } else if (boughtFood == 0) {
            System.out.printf("Henry remained hungry. He will try next weekend again.%n");

        } else if (boughtFood == 1){
            System.out.printf("Henry ate: %d food.%n", boughtFood);

        } else {
            System.out.printf("Henry ate: %d foods.%n", boughtFood);
        }


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
