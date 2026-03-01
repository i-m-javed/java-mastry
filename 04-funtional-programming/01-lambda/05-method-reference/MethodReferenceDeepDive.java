import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDeepDive {

    public static void main(String[] args) {

        System.out.println("==== STATIC METHOD REFERENCE ====");
        staticMethodReferenceDemo();

        System.out.println("\n==== INSTANCE METHOD OF PARTICULAR OBJECT ====");
        particularObjectMethodDemo();

        System.out.println("\n==== INSTANCE METHOD OF ARBITRARY OBJECT ====");
        arbitraryObjectMethodDemo();

        System.out.println("\n==== CONSTRUCTOR REFERENCE ====");
        constructorReferenceDemo();
    }

    private static void staticMethodReferenceDemo() {

        Function<String, Integer> parser = Integer::parseInt;

        System.out.println("Parsed value: " + parser.apply("100"));
    }

    private static void particularObjectMethodDemo() {

        Printer printer = new Printer();

        printer.printMessage("Using Lambda");

        // Method reference
        printer.execute(printer::printMessage);
    }

    private static void arbitraryObjectMethodDemo() {

        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("lambda");
        names.add("stream");

        names.replaceAll(String::toUpperCase);

        names.forEach(System.out::println);
    }

    private static void constructorReferenceDemo() {

        Supplier<List<String>> listSupplier = ArrayList::new;

        List<String> list = listSupplier.get();
        list.add("Constructor Reference Working");

        list.forEach(System.out::println);
    }
}

class Printer {

    void printMessage(String message) {
        System.out.println("Printing: " + message);
    }

    void execute(java.util.function.Consumer<String> consumer) {
        consumer.accept("Method Reference Executed");
    }
}