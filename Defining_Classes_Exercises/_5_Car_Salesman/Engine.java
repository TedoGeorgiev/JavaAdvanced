package Defining_Classes_Exercises._5_Car_Salesman;

public class Engine {
    //"{Model} {Power} {Displacement} {Efficiency}"

    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, String power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }



    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }


    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }


    @Override
    public String toString() {
        return String.format("%s:\n" +
                "Power: %s\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n", engineModel, power, displacement, efficiency);
    }
}
