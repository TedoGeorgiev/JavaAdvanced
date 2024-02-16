package Exams._5_Java_Advanced_Retake_Exam_12_April_2023.magazine;

import java.util.*;

public class Magazine {

    private List<Cloth> data;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (capacity > this.data.size()) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        for (Cloth cloth : data) {
            if (cloth.getColor().equals(color)) {
                data.remove(cloth);
                return true;
            }
        }
        return false;
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(cloth -> cloth.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount () {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(" magazine contains:");
        sb.append(System.lineSeparator());
        data.forEach(cloth -> {
            sb.append(cloth);
            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }


    public List<Cloth> getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
