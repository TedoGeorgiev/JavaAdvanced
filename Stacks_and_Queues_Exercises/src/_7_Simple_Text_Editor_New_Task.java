import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_Simple_Text_Editor_New_Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder textEditor = new StringBuilder();
        Deque<String> historyStack = new ArrayDeque<>();
        historyStack.push(textEditor.toString());

        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "1":
                    String addText = tokens[1];
                    textEditor.append(addText);
                    historyStack.push(textEditor.toString());
                    break;

                case "2":
                    int erase = Integer.parseInt(tokens[1]);
                    textEditor.delete(textEditor.length() - erase, textEditor.length());
                    historyStack.push(textEditor.toString());
                    break;

                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(textEditor.charAt(index - 1));

                    break;
                case "4":
                    historyStack.pop();
                    if (historyStack.peek() != null) {
                        textEditor = new StringBuilder(historyStack.peek());
                    }
                    break;
            }

        }

    }
}
