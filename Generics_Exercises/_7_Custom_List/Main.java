package Generics_Exercises._7_Custom_List;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> myList = new CustomList<>();

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String command = line.split("\\s+")[0];

            switch (command) {

                case "Add":
                    String element = line.split("\\s+")[1];
                    myList.add(element);
                    break;

                case "Remove":
                    int removeIndex = Integer.parseInt(line.split("\\s+")[1]);
                    myList.remove(removeIndex);
                    break;

                case "Contains":
                    String exist = line.split("\\s+")[1];
                    System.out.println(myList.contains(exist));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(line.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(line.split("\\s+")[2]);
                    myList.swap(firstIndex, secondIndex);
                    break;

                case "Greater":
                    String greater = line.split("\\s+")[1];
                    System.out.println(myList.countGreaterThan(greater));
                    break;

                case "Max":
                    System.out.println(myList.getMax());
                    break;

                case "Min":
                    System.out.println(myList.getMin());
                    break;

                case "Print":
                    myList.print();

            }

            line = scanner.nextLine();
        }

    }
}
