package Sets_And_Maps_Advanced_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_Phonebook_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebookMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            String name = input.split("-")[0];
            String phone = input.split("-")[1];

            phonebookMap.putIfAbsent(name, phone);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"stop".equals(input)) {
            if (phonebookMap.containsKey(input)) {
                System.out.printf("%s -> %s\n", input, phonebookMap.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }

            input = scanner.nextLine();
        }
    }
}
