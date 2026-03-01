import java.util.ArrayList;
import java.util.List;

class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

// Bounded Generic Class
class NumberBox<T extends Number> {

    private T number;

    public NumberBox(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}

// Generic Utility Class
class GenericUtil {

    // Generic Method
    public static <T> void printValue(T value) {
        System.out.println("Value: " + value);
    }

    // Generic Method with Bound
    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

public class GenericTypes {

    public static void main(String[] args) {

        System.out.println("==== GENERIC CLASS DEMO ====");
        Box<String> stringBox = new Box<>();
        stringBox.set("Java Generics");
        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());

        System.out.println("\n==== BOUNDED GENERIC DEMO ====");
        NumberBox<Integer> numberBox = new NumberBox<>(50);
        System.out.println("Double value: " + numberBox.doubleValue());

        System.out.println("\n==== GENERIC METHOD DEMO ====");
        GenericUtil.printValue("Hello");
        GenericUtil.printValue(123);

        System.out.println("\n==== GENERIC ADD METHOD ====");
        double sum = GenericUtil.add(10, 20);
        System.out.println("Sum: " + sum);

        System.out.println("\n==== GENERICS WITH COLLECTIONS ====");
        List<String> list = new ArrayList<>();
        list.add("Spring");
        list.add("Hibernate");

        for (String item : list) {
            System.out.println(item);
        }

        // System.out.println("\n==== RAW TYPE WARNING DEMO ====");
        // List rawList = new ArrayList();
        // rawList.add("Unsafe");
        // rawList.add(100); // No compile-time error

        // try {
        //     String value = (String) rawList.get(1); // Runtime failure
        //     System.out.println(value);
        // } catch (ClassCastException e) {
        //     System.out.println("Raw type caused ClassCastException!");
        // }
    }
}