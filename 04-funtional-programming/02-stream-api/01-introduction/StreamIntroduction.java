import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntroduction {

    public static void main(String[] args) {

        System.out.println("==== BASIC STREAM PIPELINE ====");
        basicStreamPipeline();

        System.out.println("\n==== LAZY EVALUATION DEMO ====");
        lazyEvaluationDemo();

        System.out.println("\n==== STREAM CREATION METHODS ====");
        streamCreationDemo();

        System.out.println("\n==== PARALLEL STREAM DEMO ====");
        parallelStreamDemo();
    }

    private static void basicStreamPipeline() {

        List<String> names = Arrays.asList("Amit", "Javed", "Ravi", "Ankit");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void lazyEvaluationDemo() {

        List<String> names = Arrays.asList("Java", "Stream", "Lambda");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 5;
                });

        System.out.println("No execution yet...");

        stream.forEach(System.out::println);
    }

    private static void streamCreationDemo() {

        Stream<String> stream = Stream.of("One", "Two", "Three");
        stream.forEach(System.out::println);

        int[] numbers = {1, 2, 3, 4};
        Arrays.stream(numbers)
                .forEach(System.out::println);
    }

    private static void parallelStreamDemo() {

        List<Integer> numbers =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        numbers.parallelStream()
                .map(n -> {
                    System.out.println(
                        Thread.currentThread().getName() + " processing " + n
                    );
                    return n * 2;
                })
                .forEach(System.out::println);
    }
}