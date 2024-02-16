package Exams._4_Java_Advanced_Retake_Exam_9_August_2023.vendingSystem;

import java.util.*;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount () {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (buttonCapacity > drinks.size()) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                drinks.remove(drink);
                return true;
            }
        }
        return false;
    }

    public Drink getLongest() {
        Optional<Drink> longestDrink = drinks.stream()
                .max(Comparator.comparingInt(Drink::getVolume));
        return longestDrink.orElse(null);

    }

    public Drink getCheapest() {
        //return drinks.stream().map(Drink::getPrice).max(Comparator.naturalOrder()).stream().findFirst().orElse(BigDecimal.ZERO);
        Optional<Drink> cheapest = drinks.stream().min(Comparator.comparing(Drink::getPrice));
        return cheapest.orElse(null);
    }

    public String buyDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                return drink.toString();
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:");
        sb.append(System.lineSeparator());
        drinks.forEach(drink -> {
            sb.append(drink.toString());
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }

}
