import java.util.ArrayList;
import java.util.List;

class Parent<T> {
    public T getValue() {
        return null;
    }
}

class Child extends Parent<String> {

    // Compiler generates bridge method here
    @Override
    public String getValue() {
        return "Bridge Method Demo";
    }
}

public class GenericsLegacy{

    public static void main(String[] args) {

        System.out.println("==== RAW TYPE DEMO ====");
        rawTypeDemo();

        System.out.println("\n==== HEAP POLLUTION DEMO ====");
        heapPollutionDemo();

        System.out.println("\n==== TYPE ERASURE DEMO ====");
        typeErasureDemo();

        System.out.println("\n==== BRIDGE METHOD POLYMORPHISM ====");
        bridgeMethodDemo();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void rawTypeDemo() {

        
        List rawList = new ArrayList();  // Raw type
        rawList.add("Java");
        rawList.add(100);  // No compile-time error

        System.out.println("Raw List: " + rawList);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void heapPollutionDemo() {

        List<String> stringList = new ArrayList<>();
        stringList.add("Safe");

        List rawList = stringList;  // Heap pollution
        rawList.add(500);           // Compiles

        try {
            String value = stringList.get(1);  // Runtime failure
            System.out.println(value);
        } catch (ClassCastException e) {
            System.out.println("Heap Pollution caused ClassCastException!");
        }
    }

    private static void typeErasureDemo() {

        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        System.out.println(
                "Same runtime class? " +
                (stringList.getClass() == intList.getClass())
        );
    }

    private static void bridgeMethodDemo() {

        Parent<String> parent = new Child();
        System.out.println(parent.getValue());
    }
}