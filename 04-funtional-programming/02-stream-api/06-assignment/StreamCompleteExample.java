import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamCompleteExample {

    // Record for Product
    record Product(String name, String category, int price) {}

    public static void main(String[] args) {

        System.out.println("===== Functional Interface Example =====");

        List<String> names = List.of("Ram", "Shyam", "Mohan");

        Predicate<String> filter = name -> name.startsWith("R");
        Function<String, String> transform = String::toUpperCase;
        Consumer<String> print = System.out::println;

        names.stream()
                .filter(filter)
                .map(transform)
                .forEach(print);

        System.out.println("\n===== Stream API Example =====");

        List<Product> products = List.of(
                new Product("bat", "sports_item", 4000),
                new Product("bails", "sports_item", 4000),
                new Product("ball", "sports_item", 2000),
                new Product("mobile", "item", 14000),
                new Product("banana", "fruit", 200),
                new Product("apple", "fruit", 300)
        );

        // 1️⃣ Grouping by category
        System.out.println("\n-- Grouping By Category --");
        Map<String, List<Product>> categoryMap =
                products.stream()
                        .collect(Collectors.groupingBy(Product::category));
        System.out.println(categoryMap);

        // 2️⃣ Sum of prices per category
        System.out.println("\n-- Total Price Per Category --");
        Map<String, Integer> totalPrice =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::category,
                                Collectors.summingInt(Product::price)
                        ));
        System.out.println(totalPrice);

        // 3️⃣ Average price per category
        System.out.println("\n-- Average Price Per Category --");
        Map<String, Double> avgPrice =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::category,
                                Collectors.averagingDouble(Product::price)
                        ));
        System.out.println(avgPrice);

        // 4️⃣ Filtering products > 2500
        System.out.println("\n-- Products Price > 2500 --");
        List<Product> filtered =
                products.stream()
                        .filter(p -> p.price() > 2500)
                        .toList();
        System.out.println(filtered);

        // 5️⃣ Mapping - Extract only prices
        System.out.println("\n-- Extracted Prices --");
        List<Integer> prices =
                products.stream()
                        .map(Product::price)
                        .toList();
        System.out.println(prices);

        // 6️⃣ Partitioning based on price > 1000
        System.out.println("\n-- Partitioning Price > 1000 --");
        Map<Boolean, List<Product>> partition =
                products.stream()
                        .collect(Collectors.partitioningBy(p -> p.price() > 1000));
        System.out.println(partition);

        // 7️⃣ Summarizing statistics
        System.out.println("\n-- Summary Statistics --");
        IntSummaryStatistics stats =
                products.stream()
                        .collect(Collectors.summarizingInt(Product::price));
        System.out.println(stats);

        // Test class example
        Test t = new Test();
        t.m1(null);
    }
}

// Separate class
class Test {
    void m1(String s) {
        System.out.println("\nTest.m1() called with: " + s);
    }
}