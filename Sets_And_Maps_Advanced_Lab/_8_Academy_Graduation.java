package Sets_And_Maps_Advanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _8_Academy_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> academyMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            List<Double> scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            academyMap.putIfAbsent(name, scores);
        }

        academyMap.forEach((name, scores) -> {
            double average = 0;
            for (Double score : scores) {
                average += score;
            }
            average = average / scores.size();
            System.out.printf("%s is graduated with %s%n", name , average);

        });
    }
}
