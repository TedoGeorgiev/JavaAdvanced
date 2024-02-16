import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _8_Browser_History_Upgrade_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> historyStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();

        while (true) {
            String line = scanner.nextLine();
            if ("Home".equals(line)) {
                break;
            }

            if ("back".equals(line)) {
                if (historyStack.size() > 1) {
                    String currentSite = historyStack.peek();
                    historyStack.pop();
                    forwardStack.push(currentSite);
                    System.out.println(historyStack.peek());


                } else {
                    System.out.println("no previous URLs");
                }

            } else if ("forward".equals(line)) {
                if (forwardStack.size() > 0) {
                    String currentSite = forwardStack.peek();
                    System.out.println(forwardStack.pop());
                    historyStack.push(currentSite);

                } else {
                    System.out.println("no next URLs");
                }

            } else {
                historyStack.push(line);
                if (forwardStack.size() > 0) {
                    forwardStack.pop();
                }
                System.out.println(line);
            }

        }
    }
}
