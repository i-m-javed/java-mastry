import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Functional Interface
@FunctionalInterface
interface Task {
    void execute();
}

public class LambdaIntroduction{

    public static void main(String[] args) {

        System.out.println("==== ANONYMOUS CLASS ====");
        anonymousClassDemo();

        System.out.println("\n==== LAMBDA EXPRESSION ====");
        lambdaDemo();

        System.out.println("\n==== BEHAVIORAL PARAMETERIZATION ====");
        behavioralParameterizationDemo();

        System.out.println("\n==== LAMBDA WITH COLLECTION SORTING ====");
        sortingDemo();
    }

    private static void anonymousClassDemo() {

        Task task = new Task() {
            @Override
            public void execute() {
                System.out.println("Executing using Anonymous Class");
            }
        };

        task.execute();
    }

    private static void lambdaDemo() {

        Task task = () -> System.out.println("Executing using Lambda");

        task.execute();
    }

    private static void behavioralParameterizationDemo() {

        executeTask(() -> System.out.println("Custom behavior passed dynamically"));
    }

    private static void executeTask(Task task) {
        task.execute();
    }

    private static void sortingDemo() {

        List<String> names = new ArrayList<>();
        names.add("Javed");
        names.add("Amit");
        names.add("Ravi");

        // Pre-Java 8 style
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("Sorted (Anonymous): " + names);

        // Java 8 Lambda style
        Collections.sort(names, (a, b) -> b.compareTo(a));

        System.out.println("Sorted (Lambda Reverse): " + names);
    }
}