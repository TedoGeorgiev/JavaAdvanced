package Generics_Exercises._7_Custom_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList <T extends Comparable<T>>{

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add (T element) {
        this.data.add(element);
    }

    public T remove (int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    public boolean contains (T element) {
        return this.data.contains(element);
    }

    public void swap (int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        int counter = 0;
        for (T el : this.data) {
            int res = el.compareTo(element);
            if (res > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        checkEmpty();
        return Collections.max(this.data);
    }

    public T getMin() {
        checkEmpty();
        return Collections.min(this.data);
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d", index, this.data.size()));
        }
    }

    public void print() {
        for (int i = 0; i < this.data.size(); i++) {
            System.out.printf("%s%n", this.data.get(i));
        }
    }
}
