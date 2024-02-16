package Sets_And_Maps_Advanced_Lab;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _2_SoftUni_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipSet = new TreeSet<>();
        Set<String> regularSet = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!"PARTY".equals(guest)) {
            char first = guest.charAt(0);
            if (Character.isDigit(first)) {
                vipSet.add(guest);
            } else {
                regularSet.add(guest);
            }

            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();
        while (!"END".equals(guest)) {
            vipSet.remove(guest);
            regularSet.remove(guest);

            guest = scanner.nextLine();
        }

        System.out.println(vipSet.size() + regularSet.size());
        for (String reg : vipSet) {
            System.out.println(reg);
        }
        for (String reg : regularSet) {
            System.out.println(reg);
        }

    }
}
