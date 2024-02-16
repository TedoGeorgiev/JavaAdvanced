package Defining_Classes_Exercises._3_Speed_Racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> carMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String [] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelConsumptionPer1KM = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelConsumptionPer1KM);
            carMap.put(model, car);
        }

        String command = scanner.nextLine();

        while (!"End".equals(command)) {
            String model = command.split("\\s+")[1];
            int distance = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = carMap.get(model);
            double fuelRequired = carToDrive.calculateRequiredFuel(distance);

            carToDrive.drive(distance);

            command = scanner.nextLine();
        }

        carMap.values().forEach(System.out::println);

    }
}
