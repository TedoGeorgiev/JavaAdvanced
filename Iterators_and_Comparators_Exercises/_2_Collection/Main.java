package Iterators_and_Comparators_Exercises._2_Collection;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator listyIterator = null;
        String input = scanner.nextLine();
        while(!"END".equals(input)) {
            String [] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Create":
                    listyIterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;

                case "Move":
                    System.out.println(listyIterator.move());
                    break;

                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;

                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                break;

                case "PrintAll":
                    for (String s : listyIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }


            input = scanner.nextLine();
        }

    }
}
