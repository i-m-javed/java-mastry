import java.util.*;

class Product implements Comparable<Product> {

    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // For HashSet uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
               Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // For TreeSet natural ordering
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}

public class SetDemo {

    public static void main(String[] args) {

        System.out.println("==== HASHSET ====");
        hashSetDemo();

        System.out.println("\n==== LINKEDHASHSET ====");
        linkedHashSetDemo();

        System.out.println("\n==== TREESET ====");
        treeSetDemo1();
        treeSetDemo2();

        System.out.println("\n==== FAIL-FAST DEMO ====");
        failFastDemo();
    }

    private static void hashSetDemo() {

        Set<Product> set = new HashSet<>();

        set.add(new Product(1, "Laptop"));
        set.add(new Product(1, "Laptop")); // Duplicate

        System.out.println("HashSet size: " + set.size());
        System.out.println(set);
    }

    private static void linkedHashSetDemo() {

        Set<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("Spring");
        set.add("Hibernate");

        System.out.println("LinkedHashSet order: " + set); // Maintains insertion order
    }

    private static void treeSetDemo1() {

        Set<Integer> set = new TreeSet<>();

        set.add(3);
        set.add(1);
        set.add(2);

        System.out.println("TreeSet sorted order: " + set); // Natural ordering (sorted)
    
    }

    private static void treeSetDemo2() {
        Set<Product> set = new TreeSet<>();

        set.add(new Product(3, "Tablet"));
        set.add(new Product(1, "Laptop"));
        set.add(new Product(2, "Smartphone"));

        System.out.println("TreeSet sorted by ID: " + set); // Sorted by natural order (ID)
    }

    private static void failFastDemo() {

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        try {
            for (Integer num : set) {
                set.remove(num); // Structural modification
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast triggered in Set.");
        }
    }
}