package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_Fix_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mailsMap = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!"stop".equals(name)) {

            String mail = scanner.nextLine();

            if (!mail.contains(".com") && !mail.contains(".us") && !mail.contains(".uk")) {
                mailsMap.putIfAbsent(name, mail);
            }

            name = scanner.nextLine();
        }

        mailsMap.forEach((key, value) -> {
            System.out.printf("%s -> %s%n", key, value);
        });
    }
}
