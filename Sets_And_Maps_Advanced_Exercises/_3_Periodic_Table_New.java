package Sets_And_Maps_Advanced_Exercises;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_Periodic_Table_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> stringSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            stringSet.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        System.out.println(String.join(" ", stringSet));

    }
}
