import java.util.ArrayDeque;
import java.util.Scanner;

public class _1_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> siteHistory = new ArrayDeque<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Home")) {
                break;
            }

            if (input.equals("back")) {
                if (siteHistory.size() <= 1) {
                    System.out.println("no previous URLs");

                } else {
                    siteHistory.pop();
                    System.out.println(siteHistory.peek());
                }

            } else {
                siteHistory.push(input);
                System.out.println(input);

            }
        }
    }
}
