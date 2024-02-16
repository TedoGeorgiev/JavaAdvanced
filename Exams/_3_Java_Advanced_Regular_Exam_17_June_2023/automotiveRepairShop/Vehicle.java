package Exams._3_Java_Advanced_Regular_Exam_17_June_2023.automotiveRepairShop;

public class Vehicle {

    //VIN: String
    //mileage: int
    //damage: String

    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public String getVIN() {
        return VIN;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return String.format("Damage: %s, Vehicle: %s (%d km)", getDamage(), getVIN(), getMileage());
    }
}
