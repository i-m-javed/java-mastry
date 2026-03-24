import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUnboxing {

    public static void main(String[] args) {

        System.out.println("==== BASIC AUTOBOXING ====");
        basicAutoboxing();

        System.out.println("\n==== ARITHMETIC AUTOBOXING COST ====");
        arithmeticAutoboxing();

        System.out.println("\n==== NULL UNBOXING RISK ====");
        nullUnboxingRisk();

        System.out.println("\n==== COLLECTION AUTOBOXING ====");
        collectionAutoboxing();

        System.out.println("\n==== COMPARISON BEHAVIOR ====");
        comparisonBehavior();
    }

    private static void basicAutoboxing() {
        Integer a = 10;  // Autoboxing
        int b = a;       // Unboxing

        System.out.println("Integer a = 10 → " + a);
        System.out.println("int b = a → " + b);
    }

    private static void arithmeticAutoboxing() {

        long startWrapper = System.nanoTime();

        Integer sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;   // Unboxing + addition + boxing
        }

        long endWrapper = System.nanoTime();

        long startPrimitive = System.nanoTime();

        int primitiveSum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            primitiveSum += i;
        }
        System.out.println(primitiveSum);

        long endPrimitive = System.nanoTime();

        System.out.println("Wrapper time (ns): " + (endWrapper - startWrapper));
        System.out.println("Primitive time (ns): " + (endPrimitive - startPrimitive));
    }

    private static void nullUnboxingRisk() {
        // Integer value = null;

        try {
            // int primitive = value;  // Causes NPE
        } catch (NullPointerException e) {
            System.out.println("Unboxing null triggered NullPointerException");
        }
    }

    private static void collectionAutoboxing() {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numbers.add(i);  // Autoboxing
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;      // Unboxing
        }

        System.out.println("Sum from List<Integer>: " + sum);
    }

    private static void comparisonBehavior() {

        Integer a = 1000;
        Integer b = 1000;

        System.out.println("a == b : " + (a == b));      // reference compare
        System.out.println("a < b  : " + (a < b));       // unboxing happens
        System.out.println("a.equals(b) : " + a.equals(b));
    }
}