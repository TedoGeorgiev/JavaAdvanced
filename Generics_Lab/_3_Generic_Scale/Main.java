package Generics_Lab._3_Generic_Scale;


public class Main {
    public static void main(String[] args) {

        Scale<Double> scale = new Scale<>(1.25 , 1.27);

        System.out.println(scale.getHeavier());
    }
}
