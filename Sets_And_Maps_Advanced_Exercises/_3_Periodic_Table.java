package Sets_And_Maps_Advanced_Exercises;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String [] elements = scanner.nextLine().split("\\s+");
            Collections.addAll(elementsSet, elements);
        }

        elementsSet.forEach(e -> {
            System.out.print(e + " ");
        });
    }
}
