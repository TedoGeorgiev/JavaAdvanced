package Defining_Classes_Exercises._4_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            //"{Model} {EngineSpeed} {EnginePower}
            // {CargoWeight} {CargoType}
            // {Tire1Pressure} {Tire1Age}
            // {Tire2Pressure} {Tire2Age}
            // {Tire3Pressure} {Tire3Age}
            // {Tire4Pressure} {Tire4Age}

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tiresList = new ArrayList<>();
            for (int j = 5; j < tokens.length; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tiresList.add(tire);
            }

            Car car = new Car(model, engine, cargo, tiresList);
            carsList.add(car);
        }

        String command = scanner.nextLine();

        if("fragile".equals(command)) {
            carsList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));

        } else {
            carsList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));

        }

    }
}
