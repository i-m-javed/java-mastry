import java.util.ArrayList;
import java.util.List;

public class PolymorphismAndGenerics {

    public static void main(String[] args) {

        System.out.println("==== INVARIANCE DEMO ====");
        invarianceDemo();

        System.out.println("\n==== COVARIANCE (? extends) DEMO ====");
        covarianceDemo();

        System.out.println("\n==== CONTRAVARIANCE (? super) DEMO ====");
        contravarianceDemo();

        System.out.println("\n==== PECS DEMO ====");
        pecsDemo();
    }

    private static void invarianceDemo() {

        List<String> strings = new ArrayList<>();
        strings.add("Java");

        // List<Object> objects = strings; // Compilation Error

        System.out.println("List<String> is NOT List<Object>");
    }

    private static void covarianceDemo() {

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);

        List<? extends Number> numbers = intList;

        for (Number n : numbers) {
            System.out.println("Read value: " + n);
        }

        // numbers.add(30); // Not allowed
    }

    private static void contravarianceDemo() {

        List<Number> numbers = new ArrayList<>();
        List<? super Integer> list = numbers;

        list.add(100);
        list.add(200);

        System.out.println("Added Integers to super list");

        Object obj = list.get(0);
        System.out.println("Read as Object: " + obj);
    }

    private static void pecsDemo() {

        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(15);

        double sum = sumNumbers(intList);
        System.out.println("Sum: " + sum);

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("After adding: " + numbers);
    }

    // Producer → extends
    private static double sumNumbers(List<? extends Number> list) {

        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Consumer → super
    private static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
}