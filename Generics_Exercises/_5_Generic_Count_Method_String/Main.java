package Generics_Exercises._5_Generic_Count_Method_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Box<String> box = new Box<>(line);
            boxList.add(box);
        }
//        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        swap(boxList, indexes[0], indexes[1]);

        Box<String> stringBox = new Box<>(scanner.nextLine());
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
