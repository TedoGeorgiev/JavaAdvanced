import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_Simple_Text_Editor_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());
        Deque<String> textEditorStack = new ArrayDeque<>();
        textEditorStack.push(text.toString());

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            String command = commands[0];
            switch (command) {

                case "1":
                    String add = commands[1];
                    text.append(add);
                    textEditorStack.push(text.toString());
                    break;

                case "2":
                    int erase = Integer.parseInt(commands[1]);
                    text.delete(text.length() - erase, text.length());
                    textEditorStack.push(text.toString());
                    break;

                case "3":
                    int printIndex = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(printIndex - 1));
                    break;

                case "4":
                    textEditorStack.pop();
                    if (!textEditorStack.isEmpty()) {
                        text = new StringBuilder(textEditorStack.peek());
                    }
                    break;

            }

        }
    }
}
