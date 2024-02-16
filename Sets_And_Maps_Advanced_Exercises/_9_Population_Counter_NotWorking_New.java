package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class _9_Population_Counter_NotWorking_New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countryMap = new LinkedHashMap<>();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        String tokens = scanner.nextLine();
        while (!"report".equals(tokens)) {

            String city = tokens.split("\\|")[0];
            String country = tokens.split("\\|")[1];
            long population = Long.parseLong((tokens.split("\\|")[2]));

            countryMap.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> cityMap = countryMap.get(country);
            cityMap.put(city, population);
            totalPopulation.putIfAbsent(country, 0L);
            long current = totalPopulation.get(country);
            totalPopulation.put(country, current + population);


            tokens = scanner.nextLine();
        }

        printMapsSorted(totalPopulation, countryMap);

        //адване в лист
//        List<Map.Entry<String, Integer>> toSort = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
//            toSort.add(entry);
//        }

        //сортиране в листа
//        toSort.sort(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)));

        //печатане на сортирания лист
//        for (Map.Entry<String, Integer> entry : toSort) {
//            writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
//        }

    }

    private static void printMapsSorted(Map<String, Long> totalPopulation, Map<String, Map<String, Long>> countryMap) {
        totalPopulation.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n",
                            entry.getKey(),
                            entry.getValue());

                    countryMap.get(entry.getKey())
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                            .forEach((pair) -> {
                                System.out.printf("=>%s: %d\n", pair.getKey(), pair.getValue());
                            });
                });
    }
}
