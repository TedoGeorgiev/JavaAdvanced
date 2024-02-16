package Defining_Classes_Exercises._7_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        Map<String, Person> personMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            String info = tokens[1];

            personMap.putIfAbsent(personName, new Person());

            switch (info) {

                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(personName).setCompany(company);
                    break;

                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(personName).getPokemons().add(pokemon);

                  break;

                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personMap.get(personName).getParents().add(parent);

                    break;

                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child children = new Child(childName, childBirthday);
                    personMap.get(personName).getChildren().add(children);

                    break;

                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    personMap.get(personName).setCar(car);

                    break;
            }

            input = scanner.nextLine();
        }

        String printPersonInfo = scanner.nextLine();
        System.out.println(printPersonInfo);
        System.out.println(personMap.get(printPersonInfo));

    }
}
