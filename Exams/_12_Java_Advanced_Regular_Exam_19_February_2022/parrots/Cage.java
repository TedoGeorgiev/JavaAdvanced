package Exams._12_Java_Advanced_Regular_Exam_19_February_2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private final List<Parrot> data;
    private final String name;
    private final int capacity;


    public Cage (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Parrot parrot) {
        if (this.capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();
        this.data.forEach(i -> {
            if (i.getSpecies().equals(species)) {
                i.setAvailable(false);
                toReturn.add(i);
            }
        });
        return toReturn;
    }

    public int count(){
        return this.data.size();
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":");
        for (Parrot r: this.data) {
            if (r.isAvailable()) {
                sb.append(System.lineSeparator());
                sb.append(r);
            }
        }
        return sb.toString();
    }
}
