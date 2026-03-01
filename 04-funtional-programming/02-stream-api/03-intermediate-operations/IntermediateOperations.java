import java.util.*;
import java.util.stream.Collectors;

public class IntermediateOperations {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Java", "Stream", "Lambda",
                "API", "Java", "Functional"
        );

        System.out.println("==== FILTER ====");
        names.stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);

        System.out.println("\n==== MAP ====");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\n==== DISTINCT ====");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n==== SORTED ====");
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n==== LIMIT ====");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n==== SKIP ====");
        names.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("\n==== PEEK (DEBUGGING) ====");
        names.stream()
                .filter(name -> name.length() > 4)
                .peek(name -> System.out.println("After filter: " + name))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println("\n==== FLATMAP ====");
        List<List<String>> nested =
                Arrays.asList(
                        Arrays.asList("A", "B"),
                        Arrays.asList("C", "D")
                );

        nested.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}