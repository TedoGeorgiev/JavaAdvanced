import java.util.ArrayDeque;
import java.util.Scanner;

public class _6_Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //George Peter Sam John Zak
        //10
        String [] players = scanner.nextLine().split("\\s+");
        int shuffle = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> gamePlayers = new ArrayDeque<>();

        for (String player : players) {
            gamePlayers.offer(player);

        }

        while (gamePlayers.size() > 1) {
            for (int i = 1; i < shuffle; i++) {
                String currentPlayer = gamePlayers.peek();
                gamePlayers.poll();
                gamePlayers.offer(currentPlayer);

            }

            System.out.println("Removed " + gamePlayers.poll());

        }
        System.out.println("Last is " + gamePlayers.poll());

    }
}
