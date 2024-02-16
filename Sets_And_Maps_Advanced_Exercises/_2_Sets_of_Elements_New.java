package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class _2_Sets_of_Elements_New {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeFirst = sizes[0];
        int sizeSecond = sizes[1];

        Set<Integer> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirst; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeSecond; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
