package Sets_And_Maps_Advanced_Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> countRealNumbers = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!countRealNumbers.containsKey(number)) {
                countRealNumbers.put(number, 1);

            } else {
                countRealNumbers.put(number, countRealNumbers.get(number) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : countRealNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
