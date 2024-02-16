import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder randomText = new StringBuilder();

        Deque<String> addStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String commands = scanner.nextLine();
            String command = commands.split("\\s+")[0];

            switch (command) {

                case "1":
                    String textAdd = commands.split("\\s+")[1];

                    addStack.push(randomText.toString());
                    randomText.append(textAdd);

                    break;

                case "2":
                    int eraseIndex = Integer.parseInt(commands.split("\\s+")[1]);

                    addStack.push(randomText.toString());

                    if (randomText.length() >= eraseIndex) {
                        for (int j = 0; j < eraseIndex; j++) {
                            randomText.deleteCharAt(randomText.length() - 1);
                        }
                    }

                    break;

                case "3":
                    int printIndex = Integer.parseInt(commands.split("\\s+")[1]);
                    System.out.println(randomText.charAt(printIndex - 1));

                    break;

                case "4":
                    if (!addStack.isEmpty()) {
                        String last = addStack.pop();
                        randomText = new StringBuilder(last);

                    }
                    break;

            }

        }


    }
}
