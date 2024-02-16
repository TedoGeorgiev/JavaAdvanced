package Exams._11_Java_Advanced_Retake_Exam_13_April_2022.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {

    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity){
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg){
        if (capacity > this.data.size()) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparingInt(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color){
        return this.data.stream()
                .filter(egg -> egg.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.material).append(" basket contains:");
        this.data.forEach(e -> {
            sb.append(System.lineSeparator());
            sb.append(e);
        });

        return sb.toString();

    }
}
