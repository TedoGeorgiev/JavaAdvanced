import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_Browser_History_Upgrade_My {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> siteHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (true) {
            String line = scanner.nextLine();
            if ("Home".equalsIgnoreCase(line)) {
                break;
            }

            if ("back".equalsIgnoreCase(line)) {
                if (siteHistory.size() <= 1) {
                    System.out.println("no previous URLs");

                } else {
                    forwardHistory.push(siteHistory.pop());
                    System.out.println(siteHistory.peek());
                }

            } else if ("forward".equalsIgnoreCase(line)) {
                if (!forwardHistory.isEmpty()) {
                    siteHistory.push(forwardHistory.pop());
                    System.out.println(siteHistory.peek());

                } else {
                    System.out.println("no next URLs");
                }

            } else {
                siteHistory.push(line);
                forwardHistory.clear();
                System.out.println(siteHistory.peek());
            }


        }

    }
}
