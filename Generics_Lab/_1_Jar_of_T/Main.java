package Generics_Lab._1_Jar_of_T;

public class Main {

    public static void main(String[] args) {

     Jar<String> stringJar = new Jar<>();

     stringJar.add("Tedi");
     stringJar.add("Ani");
     stringJar.add("marieta");
     stringJar.add("YA PA TI");

        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());

        System.out.println();
    }
}
