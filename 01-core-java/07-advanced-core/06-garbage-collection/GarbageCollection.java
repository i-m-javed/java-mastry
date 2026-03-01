class GCEmployee {

    private int id;

    public GCEmployee(int id) {
        this.id = id;
        System.out.println("Employee Created: " + id);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Employee Garbage Collected: " + id);
    }
}

public class GarbageCollection {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("==== NULLIFYING REFERENCE ====");
        nullifyingReference();

        System.out.println("\n==== REASSIGNING REFERENCE ====");
        reassigningReference();

        System.out.println("\n==== ISLAND OF ISOLATION ====");
        islandOfIsolation();

        System.out.println("\n==== MEMORY PRESSURE TEST ====");
        memoryPressureTest();

        System.out.println("\nRequesting GC...");
        System.gc();

        Thread.sleep(2000);  // Give GC time (not guaranteed)
    }

    private static void nullifyingReference() {
        GCEmployee emp = new GCEmployee(1);
        emp = null; // Eligible for GC
        System.out.println(emp); 
    }

    private static void reassigningReference() {
        @SuppressWarnings("unused")
        GCEmployee emp1 = new GCEmployee(2);
        GCEmployee emp2 = new GCEmployee(3);

        emp1 = emp2;  // Object with id=2 eligible
    }

    static class Island {
        Island reference;
        int id;

        Island(int id) {
            this.id = id;
            System.out.println("Island Object Created: " + id);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Island Object Collected: " + id);
        }
    }

    private static void islandOfIsolation() {
        Island obj1 = new Island(10);
        Island obj2 = new Island(20);

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;  // Both eligible despite circular reference
    }

    private static void memoryPressureTest() {

        for (int i = 0; i < 100; i++) {
            new GCEmployee(i);  // No reference kept → eligible
        }

        System.out.println("Created 100 temporary objects.");
    }
}