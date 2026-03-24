public class WrapperClasses {

    public static void main(String[] args) {

        System.out.println("==== INTEGER CACHING TEST ====");
        integerCachingTest();

        System.out.println("\n==== == vs equals TEST ====");
        equalityTest();

        System.out.println("\n==== AUTO-UNBOXING NPE TEST ====");
        autoUnboxingRiskTest();

        System.out.println("\n==== IMMUTABILITY PROOF ====");
        immutabilityTest();

        System.out.println("\n==== PERFORMANCE IMPACT DEMO ====");
        performanceComparison();
    }

    // Demonstrates Integer caching mechanism
    private static void integerCachingTest() {
        Integer a = 127;
        Integer b = 127;

        Integer x = 128;
        Integer y = 128;

        System.out.println("127 == 127 : " + (a == b));  // true (cached)
        System.out.println("128 == 128 : " + (x == y));  // false (new objects) 
        // // Note: This behavior is specific to Integer values between -128 and 127
    }

    // Demonstrates correct comparison
    private static void equalityTest() {
        Integer m = 1000;
        Integer n = 1000;

        System.out.println("Using ==      : " + (m == n)); // false (different objects)
        System.out.println("Using equals(): " + m.equals(n)); // true (same value)
    }

    // Shows dangerous auto-unboxing behavior
    private static void autoUnboxingRiskTest() {
        // Integer nullableValue = null;

        try {
            // int primitive = nullableValue;
        } catch (NullPointerException e) {
            System.out.println("Auto-unboxing triggered NullPointerException!");
        }
    }

    // Proves immutability behavior
    private static void immutabilityTest() {
        Integer original = 50;
        Integer referenceCopy = original;

        original = original + 10; // Creates new object

        System.out.println("Original after addition: " + original);
        System.out.println("Reference copy remains : " + referenceCopy);
    }

    // Rough performance comparison
    private static void performanceComparison() {

        long startPrimitive = System.nanoTime();
        int sumPrimitive = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sumPrimitive += i;
        }

        System.out.println(sumPrimitive);

        long endPrimitive = System.nanoTime();

        long startWrapper = System.nanoTime();
        Integer sumWrapper = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sumWrapper += i;  // Boxing & Unboxing each iteration
        }
        long endWrapper = System.nanoTime();

        System.out.println("Primitive Time (ns): " + (endPrimitive - startPrimitive)); // Much faster 
        System.out.println("Wrapper Time  (ns): " + (endWrapper - startWrapper)); // Much slower due to boxing/unboxing overhead
    }
}