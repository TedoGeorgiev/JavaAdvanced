package Exams._3_Java_Advanced_Regular_Exam_17_June_2023.automotiveRepairShop;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if (capacity > vehicles.size()) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;

    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Optional<Vehicle> lowestMileageVehicle = vehicles.stream()
                .min(Comparator.comparingInt(Vehicle::getMileage));
        return lowestMileageVehicle.orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        sb.append(System.lineSeparator());
        vehicles.forEach(vehicle -> {
            sb.append(vehicle);
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }
}
