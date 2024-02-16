package Sets_And_Maps_Advanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _5_Average_Students_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            if (!studentMap.containsKey(name)) {
                studentMap.put(name, new ArrayList<>());
                studentMap.get(name).add(grade);

            } else {
                studentMap.get(name).add(grade);
            }

        }

        for (Map.Entry<String, List<Double>> entry : studentMap.entrySet()) {
            double average = 0;
            System.out.printf("%s -> ", entry.getKey());
            List<Double> grades = entry.getValue();
            for (Double grade : grades) {
                average +=grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)%n", average / grades.size());
        }

//        studentMap.forEach((name, grades) -> {
//            double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
//            String formattedGrades = grades.stream()
//                    .map(grade -> String.format("%.2f", grade))
//                    .collect(Collectors.joining(" "));
//            System.out.printf("%s -> %s (avg: %.2f)%n", name, formattedGrades, average);
//        });
    }
}
