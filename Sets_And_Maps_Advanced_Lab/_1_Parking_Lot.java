package Sets_And_Maps_Advanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String command = input.split(", ")[0];
            String reg = input.split(", ")[1];

            switch (command) {
                case "IN":
                    parkingSet.add(reg);
                    break;
                case "OUT":
                    parkingSet.remove(reg);
                    break;
            }

            input = scanner.nextLine();
        }

        if (parkingSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String reg : parkingSet) {
                System.out.println(reg);
            }
        }
    }
}
