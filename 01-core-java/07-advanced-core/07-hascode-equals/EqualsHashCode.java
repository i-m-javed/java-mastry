import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User {

    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Correct equals implementation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                    Objects.equals(name, user.name);
    }

    // Correct hashCode implementation
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class EqualsHashCode {

    public static void main(String[] args) {

        System.out.println("==== REFERENCE vs LOGICAL EQUALITY ====");
        equalityTest();

        System.out.println("\n==== HASHSET BEHAVIOR ====");
        hashSetTest();

        System.out.println("\n==== HASHCODE CONSISTENCY ====");
        hashCodeConsistencyTest();
    }

    private static void equalityTest() {

        User u1 = new User(1, "Javed");
        User u2 = new User(1, "Javed");

        System.out.println("u1 == u2 : " + (u1 == u2));
        System.out.println("u1.equals(u2) : " + u1.equals(u2));
    }

    private static void hashSetTest() {

        Set<User> users = new HashSet<>();

        users.add(new User(1, "Javed"));
        users.add(new User(1, "Javed")); // Should NOT duplicate

        System.out.println("HashSet Size: " + users.size());
        System.out.println("Users: " + users);
    }

    private static void hashCodeConsistencyTest() {

        User user = new User(10, "CoreJava");

        int hash1 = user.hashCode();
        int hash2 = user.hashCode();

        System.out.println("HashCode first call : " + hash1);
        System.out.println("HashCode second call: " + hash2);
        System.out.println("Consistent? " + (hash1 == hash2));
    }
}