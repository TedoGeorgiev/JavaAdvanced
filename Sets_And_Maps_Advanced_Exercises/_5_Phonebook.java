package Sets_And_Maps_Advanced_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contactsMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)) {

            String name = input.split("-")[0];
            String number = input.split("-")[1];

            contactsMap.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!"stop".equals(input)) {

            if (!contactsMap.containsKey(input)) {
                System.out.printf("Contact %s does not exist.%n", input);

            } else {
                System.out.printf("%s -> %s%n", input, contactsMap.get(input));
            }

            input = scanner.nextLine();
        }

    }
}
