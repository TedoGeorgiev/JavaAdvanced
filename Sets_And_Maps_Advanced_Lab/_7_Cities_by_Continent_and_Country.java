package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class _7_Cities_by_Continent_and_Country {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> continentMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentMap.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> countryMap = continentMap.get(continent);
            if (!countryMap.containsKey(country)) {
                countryMap.put(country, new ArrayList<>());
                countryMap.get(country).add(city);

            } else {
                countryMap.get(country).add(city);
            }

        }

        continentMap.forEach((entry, countryMap) -> {
                    System.out.printf("%s:%n", entry);
                    countryMap.forEach((country, cityList) -> System.out.printf("  %s -> %s%n", country, String.join(", ", cityList)));
        });
    }
}
