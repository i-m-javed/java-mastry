import java.util.function.*;

@FunctionalInterface
interface Calculator {
    int operate(int a, int b);

    default void description() {
        System.out.println("Calculator Functional Interface");
    }

    static void helper() {
        System.out.println("Static helper method");
    }
}

public class FunctionalInterfaces {

    public static void main(String[] args) {

        System.out.println("==== CUSTOM FUNCTIONAL INTERFACE ====");
        customFunctionalInterfaceDemo();

        System.out.println("\n==== BUILT-IN FUNCTIONAL INTERFACES ====");
        builtInFunctionalInterfacesDemo();
    }

    private static void customFunctionalInterfaceDemo() {

        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;

        System.out.println("Addition: " + addition.operate(10, 5));
        System.out.println("Multiplication: " + multiplication.operate(10, 5));

        addition.description();
        Calculator.helper();
    }

    private static void builtInFunctionalInterfacesDemo() {

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println("Length of Java: " + lengthFunction.apply("Java"));

        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Lambda");

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random Value: " + randomSupplier.get());
    }
}