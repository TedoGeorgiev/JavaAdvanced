package Defining_Classes_Exercises._9_Cat_Lady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Cat> catMap = new HashMap<>();
        while (!"End". equals(line)) {
        String [] tokens = line.split("\\s+");

        String catType = tokens[0];
        String name = tokens[1];

        Cat cat = null;
        switch (catType) {

            case "Siamese":
                double earSize = Double.parseDouble(tokens[2]);
                cat = new Siamese(name, earSize);
                break;

            case "Cymric":
                double furLength = Double.parseDouble(tokens[2]);
                cat = new Cymric(name, furLength);
                break;

            case "StreetExtraordinaire":
                double decibelsOfMeows = Double.parseDouble(tokens[2]);
                cat = new StreetExtraordinaire(name, decibelsOfMeows);
                break;
        }

        catMap.putIfAbsent(name, cat);
            line = scanner.nextLine();
        }

        String findCat = scanner.nextLine();

        if (catMap.containsKey(findCat)) {
            System.out.println(catMap.get(findCat));
        }
    }
}
