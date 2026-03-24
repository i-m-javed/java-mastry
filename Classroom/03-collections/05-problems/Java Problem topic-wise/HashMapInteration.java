import java.util.*;

public class HashMapInteration {
    public static void main(String[] args) {
        HashMap<Integer, String> m1 = new HashMap<>();
        HashMap<Integer, String> m2 = new HashMap<>();

        m1.put(1, "Java");
        m1.put(2, "Python");

        // 1️⃣ entrySet
        for (var v : m1.entrySet()) {
            System.out.println(v.getKey() + " -> " + v.getValue());
        }

        // 2️⃣ keySet
        for (var v : m1.keySet()) {
            System.out.println("Key: " + v);
            System.out.println("Value: " + m1.get(v));
        }

        // 3️⃣ values
        for (var v : m1.values()) {
            System.out.println("Value only: " + v);
        }
    }
}