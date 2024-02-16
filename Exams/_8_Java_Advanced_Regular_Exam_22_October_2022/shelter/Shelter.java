package Exams._8_Java_Advanced_Regular_Exam_22_October_2022.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Shelter {

    private List<Animal> data;
    private int capacity;


    public Shelter (int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Animal animal) {
        if (capacity > data.size()) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (name.equals(animal.getName())) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : data) {
            if(name.equals(animal.getName()) && caretaker.equals(animal.getCaretaker())) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparingInt(Animal::getAge)).orElse(null);
    }

    public int getCount () {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());
        data.forEach(animal -> {
            sb.append(animal.getName()).append(" ").append(animal.getCaretaker());
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

}
