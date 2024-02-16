package Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _8_User_Logs_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //IP=192.23.30.40 message='Hello&derps.' user=destroyer
        //IP=192.23.30.41 message='Hello&yall.' user=destroyer
        //IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message='Hey&son' user=mother

        Map<String, Map<String, Integer>> userMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String [] tokens = input.split("\\s+");
            String user = tokens[2].split("=")[1];
            String IP = tokens[0].split("=")[1];

            userMap.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> ipMap = userMap.get(user);

            if (!ipMap.containsKey(IP)) {
                ipMap.put(IP, 1);
            } else {
                ipMap.put(IP, ipMap.get(IP) + 1);
            }

            input = scanner.nextLine();
        }

        userMap.forEach((key, value) -> {
            System.out.printf("%s:\n", key);

            StringBuilder resultBuilder = new StringBuilder();

            value.forEach((K, V) -> resultBuilder.append(String.format("%s => %d, ", K, V)));
            resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length()); // Remove the last ", "
            resultBuilder.append(".");

            System.out.println(resultBuilder);
        });
    }
}
