import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println("==== COUNT ====");
        long count = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Even count: " + count);

        System.out.println("\n==== REDUCE (SUM) ====");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Total sum: " + sum);

        System.out.println("\n==== MAX ====");
        Optional<Integer> max =
                numbers.stream()
                        .max(Integer::compareTo);
        max.ifPresent(System.out::println);

        System.out.println("\n==== FIND FIRST ====");
        Optional<Integer> firstEven =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .findFirst();
        firstEven.ifPresent(System.out::println);

        System.out.println("\n==== ANY MATCH ====");
        boolean anyGreaterThan8 =
                numbers.stream()
                        .anyMatch(n -> n > 8);
        System.out.println(anyGreaterThan8);

        System.out.println("\n==== COLLECT TO LIST ====");
        List<Integer> squared =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList());
        System.out.println(squared);

        System.out.println("\n==== GROUPING EXAMPLE ====");
        Map<String, List<String>> grouped =
                Arrays.asList("Java", "Stream", "Lambda", "Spring")
                        .stream()
                        .collect(Collectors.groupingBy(
                                word -> word.substring(0,1)
                        ));

        System.out.println(grouped);
    }
}