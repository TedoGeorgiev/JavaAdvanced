package Functional_Programming_Exercises;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _9_List_of_Predicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Function<������, �����> -> apply
        //Consumer<������> -> void -> accept
        //Supplier<�����> -> get
        //Predicate<������> -> ����� true / false -> test
        //BiFunction<������1, ������2, �����> -> apply

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //���������� ������ ����� �� 1 �� n, ��� �� ���� �� ������ ����� � �������

        //�������: �����, ������ �� ��������
        //������: true / false
        //true -> ��� ������� �� ���� �� ������ ����� � �������
        //false -> ��� ������� �� �� ���� �� ������ ����� � �������
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (int numInList : list) {
                if (number % numInList != 0) {
                    return false;
                }
            }
            //��������� ���� ������ ����� � ������� � ������ ����� number
            return true;
        });

        for (int number = 1; number <= n; number++) {
            if (isDivisible.apply(number, numbers)) {
                System.out.print(number + " ");
            }
        }

    }
}
