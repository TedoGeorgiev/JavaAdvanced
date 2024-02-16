package Sets_And_Maps_Advanced_Exercises;

import java.util.*;
import java.util.stream.Collectors;


public class _9_Population_Counter_NotWorking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> countryMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);

            if (!countryMap.containsKey(country)) {
                countryMap.put(country, new LinkedHashMap<>());
                LinkedHashMap<String, Long> cityMap = countryMap.get(country);
                cityMap.putIfAbsent(city, population);

            } else {
                LinkedHashMap<String, Long> cityMap = countryMap.get(country);
                cityMap.putIfAbsent(city, population);
            }

            input = scanner.nextLine();
        }

        long maxPopulation = Integer.MIN_VALUE;
        List<String> sortCountry = new ArrayList<>();
        sortCountriesInList(countryMap, maxPopulation, sortCountry);

        for (String country : sortCountry) {
            int sum = 0;
            LinkedHashMap<String, Long> cityMap = getSorted(countryMap.get(country));

            for (Long value : cityMap.values()) {
                sum += value;
            }

            System.out.printf("%s (total population: %d)%n", country, sum);
            for (Map.Entry<String, Long> city : cityMap.entrySet()) {
                System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());

            }
        }

    }

    private static void sortCountriesInList(Map<String, LinkedHashMap<String, Long>> countryMap, long maxPopulation, List<String> sortCountry) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> country : countryMap.entrySet()) {
            long sumPopulation = 0;
            LinkedHashMap<String, Long> cityMap = country.getValue();
            for (long value : cityMap.values()) {
               sumPopulation += value;
            }
            if (sumPopulation > maxPopulation) {
                maxPopulation = sumPopulation;
                sortCountry.add(0, country.getKey());
            } else {
                sortCountry.add(country.getKey());
            }
        }
    }

    private static LinkedHashMap<String, Long> getSorted(Map<String, Long> countryMap) {
        return countryMap.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}