import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

    public static void main(String[] args) {

        System.out.println("==== ARRAYLIST BEHAVIOR ====");
        arrayListDemo();

        System.out.println("\n==== LINKEDLIST BEHAVIOR ====");
        linkedListDemo();

        System.out.println("\n==== VECTOR BEHAVIOR ====");
        vectorDemo();

        System.out.println("\n==== FAIL-FAST DEMO ====");
        failFastDemo();

        System.out.println("\n==== FAIL-SAFE DEMO ====");
        failSafeDemo();

        System.out.println("\n==== PERFORMANCE COMPARISON ====");
        performanceComparison();
    }

    private static void arrayListDemo() {

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Spring");
        list.add("Java");   // Duplicate allowed
        list.add(null);     // Null allowed

        System.out.println("ArrayList: " + list);
        System.out.println("Element at index 1: " + list.get(1));
    }

    private static void linkedListDemo() {

        LinkedList<String> list = new LinkedList<>();

        list.addFirst("Core");
        list.addLast("Collections");
        list.add("Framework");

        System.out.println("LinkedList: " + list);

        list.removeFirst();
        System.out.println("After removeFirst(): " + list);
    }

    private static void vectorDemo() {

        Vector<String> vector = new Vector<>();

        vector.add("Legacy");
        vector.add("Thread-Safe");
        vector.add("Synchronized");

        System.out.println("Vector: " + vector);
    }

    private static void failFastDemo() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        try {
            for (Integer num : list) {
                if (num == 2) {
                    list.remove(num); // Structural modification
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast triggered: " + e.getClass().getSimpleName());
        }
    }

    private static void failSafeDemo() {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(10);
        list.add(20);

        for (Integer num : list) {
            if(num == 20) {
                list.remove(num); // Structural modification allowed
            }
        }

        System.out.println("Fail-Safe List after modification: " + list);
    }

    private static void performanceComparison() {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startArray = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(i);
        }
        long endArray = System.nanoTime();

        long startLinked = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        long endLinked = System.nanoTime();

        System.out.println("ArrayList access time: " + (endArray - startArray)); // O(1) access time
        System.out.println("LinkedList access time: " + (endLinked - startLinked)); // O(n) access time
    }
}