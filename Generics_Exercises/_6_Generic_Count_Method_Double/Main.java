package Generics_Exercises._6_Generic_Count_Method_Double;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(number);
            boxList.add(box);
        }
//        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        swap(boxList, indexes[0], indexes[1]);

        Box<Double> stringBox = new Box<>(Double.parseDouble(scanner.nextLine()));
        int count = count(boxList, stringBox);
        System.out.println(count);

        //boxList.forEach(System.out::println);
    }

    static <T> void swap (List<T> list, int firstIndex, int secondIndex) {

        T firstElement = list.get(firstIndex);
        T secondElement =list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);

    }

    static <T extends Comparable<T>> int count (List<T> list, T element) {
        int count = 0;

        for (T el : list) {
            int result = el.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }
}
