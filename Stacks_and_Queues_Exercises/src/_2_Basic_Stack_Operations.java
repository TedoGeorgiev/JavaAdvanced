import java.util.*;

public class _2_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        String[] firstLine = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);

        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e-> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < n; i++) {
            numbersStack.push(numbers[i]);

        }

        for (int i = 0; i < s; i++) {
            numbersStack.pop();
        }

        if (numbersStack.isEmpty()) {
            System.out.println("0");

        } else {
            if (numbersStack.contains(x)) {
                System.out.println("true");

            } else {
                System.out.println(Collections.min(numbersStack));

            }
        }
    }
}
