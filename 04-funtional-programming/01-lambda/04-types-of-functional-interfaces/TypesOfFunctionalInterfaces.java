import java.util.function.*;

public class TypesOfFunctionalInterfaces{

    public static void main(String[] args) {

        System.out.println("==== UNARY OPERATOR ====");
        unaryOperatorDemo();

        System.out.println("\n==== BINARY OPERATOR ====");
        binaryOperatorDemo();

        System.out.println("\n==== BI-FUNCTIONAL INTERFACES ====");
        biFunctionalDemo();

        System.out.println("\n==== CHAINING DEMO ====");
        chainingDemo();

        System.out.println("\n==== CONSUMER EXAMPLE ====");
        ConsumerExample();

        System.out.println("\n==== SUPPLIER EXAMPLE ====");
        SupplierExample();

        System.out.println("\n==== FUNCTION EXAMPLE ====");
        FunctionExample();

        System.out.println("\n==== PREDICATE EXAMPLE ====");
        PredicateExample();
        
    }

    private static void unaryOperatorDemo() {

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));
    }

    private static void binaryOperatorDemo() {

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("Sum of 10 and 20: " + sum.apply(10, 20));
    }

    private static void biFunctionalDemo() {

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println("Is 10 > 5? " + isGreater.test(10, 5));

        BiFunction<Integer, Integer, String> combine =
                (a, b) -> "Result: " + (a + b);
        System.out.println(combine.apply(5, 7));

        BiConsumer<String, Integer> printer =
                (name, age) -> System.out.println(name + " is " + age + " years old");
        printer.accept("Javed", 25);
    }


    private static void chainingDemo() {

        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add5 = x -> x + 5;

        Function<Integer, Integer> combined =
                multiplyBy2.andThen(add5);

        System.out.println("Combined result: " + combined.apply(10));

        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;

        Predicate<Integer> combinedPredicate =
                isPositive.and(isEven);

        System.out.println("Is 10 positive and even? " +
                combinedPredicate.test(10));
    }


    public static void ConsumerExample(){
        Consumer<String> consumer= new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Consumer Inner class");
        Consumer<Integer> consumer1= number->{
            System.out.println(number);
        };
        consumer1.accept(20);
    }

    public static void SupplierExample(){
        Supplier<String> supplier= new Supplier<String>() {
            @Override
            public String get() {
                return "Supplier Inner class";
            }
        };
        System.out.println(supplier.get());
        Supplier<Integer> supplier1=()->{
            return 100;
        };
        System.out.println(supplier1.get());  
    }

    public static void FunctionExample(){
        Function<String, Integer> function= new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(function.apply("Function Inner class"));
        Function<String, Integer> function1=s->s.length();
        System.out.println(function1.apply("Lambda Function"));
    }

    public static void PredicateExample(){
        Predicate<String> predicate= new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
        Predicate<String> predicate1=s->s.isEmpty();
        System.out.println(predicate1.test("Not Empty"));
    }   
}