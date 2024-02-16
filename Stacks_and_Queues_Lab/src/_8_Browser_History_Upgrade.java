import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> siteHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Home")) {
                break;
            }

            if (input.equals("back")) {
                if (siteHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.push(siteHistory.pop());
                    System.out.println(siteHistory.peek());
                }

            } else if (input.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    siteHistory.push(forwardHistory.pop());
                    System.out.println(siteHistory.peek());
                }

            } else {
                siteHistory.push(input);
                forwardHistory.clear(); // Clear forward history when a new page is visited
                System.out.println(input);
            }
        }
    }
}