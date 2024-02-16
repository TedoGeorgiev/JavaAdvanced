package Generics_Lab._2_Generic_Array_Creator;

public class Main {
    public static void main(String[] args) {

        String [] arr = ArrayCreator.<String>create(5, "zero");
        Integer[] arrN = ArrayCreator.<Integer>create(4, 0);

        Double[] arrD = ArrayCreator.<Double>create(Double.class, 5, 0.00);

        System.out.println();

    }
}
