package Defining_Classes_Lab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carNumber = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            String [] carDetails = scanner.nextLine().split("\\s+");
            if (carDetails.length == 1) {
                Car car = new Car(carDetails[0]);
                cars.add(car);
            } else {
                Car car = new Car(carDetails[0], carDetails[1], Integer.parseInt(carDetails[2]));
                cars.add(car);
            }


        }

        cars.forEach(car -> {
            System.out.println(car.carInfo());
        });


    }
}
