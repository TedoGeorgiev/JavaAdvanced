package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class _6_Product_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> shopMap = new TreeMap<>();
        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            shopMap.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> productMap = shopMap.get(shop);
            productMap.putIfAbsent(product, price);

            input = scanner.nextLine();
        }

        shopMap.forEach((key, productMap) -> {
            System.out.println(key + "->");
            productMap.forEach((key1, value) -> System.out.printf("Product: %s, Price: %.1f%n", key1, value));
        });
    }
}
