class Counter {

    private int count = 0;

    // Unsynchronized method (race condition)
    public void incrementUnsafe() {
        count++;
    }

    // Synchronized method
    public synchronized void incrementSafe() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizationAndLocks {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Race Condition Demo ===");

        Counter counter1 = new Counter();

        Runnable unsafeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter1.incrementUnsafe();
            }
        };

        Thread t1 = new Thread(unsafeTask);
        Thread t2 = new Thread(unsafeTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Unsafe Count: " + counter1.getCount());

        System.out.println("\n=== Synchronized Demo ===");

        Counter counter2 = new Counter();

        Runnable safeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter2.incrementSafe();
            }
        };

        Thread t3 = new Thread(safeTask);
        Thread t4 = new Thread(safeTask);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Safe Count: " + counter2.getCount());
    }
}