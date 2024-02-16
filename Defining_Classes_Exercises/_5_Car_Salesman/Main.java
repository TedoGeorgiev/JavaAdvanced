package Defining_Classes_Exercises._5_Car_Salesman;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int engineNumber = Integer.parseInt(scanner.nextLine());


        Map<String, Engine> engineMap = new HashMap<>();

        for (int i = 0; i < engineNumber; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            String power = tokens[1];

            Engine engine = null;
            switch (tokens.length) {
                case 2:
                    engine = new Engine(engineModel, power, "n/a", "n/a");
                    break;

                case 3:
                    if (tokens[2].matches("\\d+")) {
                        String displacement = tokens[2];
                        engine = new Engine(engineModel, power, displacement, "n/a");

                    } else {
                        String efficiency = tokens[2];
                        engine = new Engine(engineModel, power, "n/a", efficiency);
                    }
                    break;

                case 4:
                    String displacement = tokens[2];
                    String efficiency = tokens[3];
                    engine = new Engine(engineModel, power, displacement, efficiency);
                    break;
            }
            engineMap.putIfAbsent(engineModel, engine);

        }

        System.out.println();


        List<Car> carList = new ArrayList<>();
        int carNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < carNumber; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String carModel = tokens[0];
            String engine = tokens[1];
            Engine carEngine = null;

            if (engineMap.containsKey(engine)) {
                carEngine = engineMap.get(engine);
            }

            Car car = null;
            switch (tokens.length) {
                case 2:
                    car = new Car(carModel, carEngine , "n/a", "n/a");
                    break;

                case 3:
                    if (tokens[2].matches("\\d+")) {
                        String weight = tokens[2];
                        car = new Car(carModel, carEngine, weight, "n/a");

                    } else {
                        String color = tokens[2];
                        car = new Car(carModel, carEngine, "n/a", color);
                    }
                    break;

                case 4:
                    String weight = tokens[2];
                    String color = tokens[3];
                    car = new Car(carModel, carEngine, weight, color);
                    break;
            }

            carList.add(car);
        }

        carList.forEach(System.out::print);
    }

}
