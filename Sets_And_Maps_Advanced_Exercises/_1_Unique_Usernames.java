package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            names.add(name);
        }

        names.forEach(System.out::println);
    }
}
