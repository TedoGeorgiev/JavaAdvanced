package Iterators_and_Comparators_Exercises._5_Comparing_Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String name = line.split("\\s+")[0];
            int age = Integer.parseInt(line.split("\\s+")[1]);
            String town = line.split("\\s+")[2];

            Person person = new Person(name, age, town);
            peopleList.add(person);

            line = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine());
        Person comparePerson = peopleList.get(index - 1);

        int equal = 0;

        for (Person person : peopleList) {
            if (comparePerson.compareTo(person) == 0) {
                equal++;
            }
        }

        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", equal, peopleList.size() - equal, peopleList.size());
        }


    }
}
