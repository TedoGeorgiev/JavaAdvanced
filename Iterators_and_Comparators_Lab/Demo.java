package Iterators_and_Comparators_Lab;

public class Demo {
    public static void main(String[] args) {

        testVarArgs("Pesho", "Gosho", "Stamat");
        testVarArgs(" ");

    }

    public static void testVarArgs (String... values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

    }
}
