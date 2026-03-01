import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class UserKey {

    private final int id;
    private final String name;

    public UserKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Proper equals & hashCode for HashMap key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserKey)) return false;
        UserKey userKey = (UserKey) o;
        return id == userKey.id &&
                Objects.equals(name, userKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + "-" + name;
    }
}

public class MapDemo {

    public static void main(String[] args) {

        System.out.println("==== HASHMAP DEMO ====");
        hashMapDemo();

        System.out.println("\n==== LINKEDHASHMAP ORDER ====");
        linkedHashMapDemo();

        System.out.println("\n==== TREEMAP SORTING ====");
        treeMapDemo();

        System.out.println("\n==== CONCURRENTHASHMAP DEMO ====");
        concurrentHashMapDemo();

        System.out.println("\n==== FAIL-FAST DEMO ====");
        failFastDemo();
    }

    private static void hashMapDemo() {

        Map<UserKey, String> map = new HashMap<>();

        UserKey key1 = new UserKey(1, "Javed");
        UserKey key2 = new UserKey(1, "Javed");

        map.put(key1, "Admin");
        map.put(key2, "Admin Duplicate");

        System.out.println("HashMap size: " + map.size());
        System.out.println("Value retrieval: " + map.get(key1));
    }

    private static void linkedHashMapDemo() {

        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println("Insertion Order: " + map);
    }

    private static void treeMapDemo() {

        Map<Integer, String> map = new TreeMap<>();

        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println("Sorted Order: " + map);
    }

    private static void concurrentHashMapDemo() {

        Map<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "One");
        map.put(2, "Two");

        System.out.println("ConcurrentHashMap: " + map);
    }

    private static void failFastDemo() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        try {
            for (Integer key : map.keySet()) {
                map.remove(key); // Structural modification
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast triggered in Map.");
        }
    }
}