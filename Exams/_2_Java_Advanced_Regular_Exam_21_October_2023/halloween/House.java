package Exams._2_Java_Advanced_Regular_Exam_21_October_2023.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }
    public void addKid(Kid kid) {
        if (capacity > data.size()) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        for (Kid kid : data) {
            if (kid.getName().equals(name)) {
                data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public Kid getKid(String street){
        for (Kid kid : data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:");
        sb.append(System.lineSeparator());
        data.forEach(kid -> {
            sb.append(kid.getName()).append(" from ").append(kid.getStreet()).append(" street");
            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }


}
