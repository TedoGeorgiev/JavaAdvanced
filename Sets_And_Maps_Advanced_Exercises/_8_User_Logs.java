package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _8_User_Logs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message='Hey&son' user=mother
        //IP=192.23.33.40 message='Hi&mom!' user=child0

        Map<String, LinkedHashMap<String, Integer>> userMap = new TreeMap<>();

        String tokens = scanner.nextLine();
        while (!"end".equals(tokens)) {

            String [] input = tokens.split("\\s+");

            String IP = input[0].split("=")[1];
            String username = input[2].split("=")[1];

            if (!userMap.containsKey(username)) {
                userMap.put(username, new LinkedHashMap<>());
                LinkedHashMap<String, Integer> IPMap = userMap.get(username);

                if (!IPMap.containsKey(IP)) {
                    IPMap.put(IP, 1);
                } else {
                    IPMap.put(IP, IPMap.get(IP) + 1);
                }

            } else {
                LinkedHashMap<String, Integer> IPMap = userMap.get(username);
                if (!IPMap.containsKey(IP)) {
                    IPMap.put(IP, 1);
                } else {
                    IPMap.put(IP, IPMap.get(IP) + 1);
                }
            }

            tokens = scanner.nextLine();
        }

        userMap.forEach((key, value) -> {
            System.out.printf("%s:%n", key);

            int count = 0;
            int totalIPs = value.size();

            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                System.out.printf("%s => %d", entry.getKey(), entry.getValue());
                count++;

                // Add a comma and space if it's not the last IP
                if (count < totalIPs) {
                    System.out.print(", ");
                } else {
                    // Add a dot at the end if it's the last IP
                    System.out.print(".\n");
                }
            }
        });
    }
}
