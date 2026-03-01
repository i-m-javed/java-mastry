import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class WritingLambdasDeepDive {

    private int instanceValue = 50;

    public static void main(String[] args) {

        WritingLambdasDeepDive demo = new WritingLambdasDeepDive();

        System.out.println("==== TYPE INFERENCE DEMO ====");
        demo.typeInferenceDemo();

        System.out.println("\n==== BLOCK VS EXPRESSION DEMO ====");
        demo.blockVsExpressionDemo();

        System.out.println("\n==== EFFECTIVELY FINAL DEMO ====");
        demo.effectivelyFinalDemo();

        System.out.println("\n==== LAMBDA SCOPE DEMO ====");
        demo.lambdaScopeDemo();
    }

    private void typeInferenceDemo() {

        BinaryOperator<Integer> add = (a, b) -> a + b;

        System.out.println("Sum: " + add.apply(10, 20));
    }

    private void blockVsExpressionDemo() {

        BinaryOperator<Integer> multiply = (a, b) -> {
            int result = a * b;
            return result;
        };

        System.out.println("Multiply: " + multiply.apply(5, 4));
    }

    private void effectivelyFinalDemo() {

        int localValue = 100;

        Consumer<String> printer = msg ->
                System.out.println(msg + " | Local Value: " + localValue);

        printer.accept("Lambda Working");

        // localValue = 200; // Uncommenting this causes compilation error
    }

    private void lambdaScopeDemo() {

        Runnable r = () -> {
            System.out.println("Instance value using lambda: " + this.instanceValue);
            System.out.println("this refers to enclosing class: " + this.getClass().getSimpleName());
        };

        r.run();
    }
}