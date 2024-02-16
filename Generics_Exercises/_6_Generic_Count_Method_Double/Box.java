package Generics_Exercises._6_Generic_Count_Method_Double;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.data.compareTo(other.data);
    }
}
