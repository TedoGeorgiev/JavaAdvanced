package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {
    private List<Shark> sharks;
    private String name;
    private int capacity;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark){
        if (this.capacity > this.sharks.size()) {
            this.sharks.add(shark);

        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind){
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                this.sharks.remove(shark);
                return true;
            }
        }

        return false;
    }

    public Shark getLargestShark(){
        return this.sharks.stream()
                .max(Comparator.comparing(Shark::getLength))
                .orElse(null);
    }

    public Shark getShark(String kind){
        return this.sharks.stream()
                .filter(shark -> shark.getKind().equals(kind))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.sharks.size();
    }

    public int getAverageLength(){
        return (int) this.sharks.stream().mapToInt(Shark::getLength).average().getAsDouble();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Sharks in ").append(this.name).append(":");

        this.sharks.forEach(shark -> {
            sb.append(System.lineSeparator());
            sb.append(shark);
        });

        return sb.toString();
    }


}
