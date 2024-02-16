package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class _6_Fix_Emails_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mailMap = new LinkedHashMap<>();
        Set<String> blockedSet = new HashSet<>();
        blockedSet.add("us");
        blockedSet.add("uk");
        blockedSet.add("com");

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String mail = scanner.nextLine();
            String domain = mail.split("@")[1];
            String check = domain.split("\\.")[1];

            if (!blockedSet.contains(check)) {
                mailMap.putIfAbsent(input, mail);
            }

            input = scanner.nextLine();
        }

        mailMap.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));

    }
}
