package Defining_Classes_Exercises._5_Car_Salesman;

public class Car {
//model, engine, weight, and color

    private String carModel;
    private Engine carEngine;
    private String weight;
    private String color;

    public Car(String carModel, Engine carEngine, String weight, String color) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                "%s" +
                "Weight: %s\n" +
                "Color: %s\n", carModel,
                carEngine, weight, color);

//Displacement: 28
//Efficiency: B
//Weight: 1300
//Color: Silver
    }
}
