import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _1_Browser_History_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Deque<String> historyStack = new ArrayDeque<>();



        while (!line.equalsIgnoreCase("Home")) {
            if (line.equals("back")) {
                if (historyStack.size() > 1) {
                    historyStack.pop();
                    System.out.println(historyStack.peek());

                } else {
                    System.out.println("no previous URLs");
                }


            } else {
                historyStack.push(line);
                System.out.println(line);
            }

            line = scanner.nextLine();
        }


    }
}
