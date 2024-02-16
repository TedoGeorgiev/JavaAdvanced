package Defining_Classes_Exercises._6_Pokemon_Trainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> trainerMap = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!"Tournament".equals(line)) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainerMap.putIfAbsent(trainerName, new ArrayList<>());
            trainerMap.get(trainerName).add(pokemon);

            line = scanner.nextLine();
        }

        List<Trainer> trainerList = trainerMap.entrySet().stream()
                        .map(entry -> new Trainer(entry.getKey(), entry.getValue()))
                                .collect(Collectors.toList());


        line = scanner.nextLine();

        while (!"End".equals(line)) {

            for (Trainer trainer : trainerList) {
                trainer.executeCommand(line);
            }

            line = scanner.nextLine();
        }

        trainerList.stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(System.out::println);
    }
}
