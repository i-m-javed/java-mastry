class LockExample {

    public synchronized void lockedMethod() {
        try {
            Thread.sleep(2000); // Causes TIMED_WAITING
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadStates {

    public static void main(String[] args) throws InterruptedException {

        LockExample example = new LockExample();

        Thread t1 = new Thread(() -> {
            example.lockedMethod();
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            example.lockedMethod();
        }, "Thread-2");

        System.out.println("Initial State: " + t1.getState()); // NEW

        t1.start();
        Thread.sleep(100); // Give time to acquire lock

        System.out.println("After start(): " + t1.getState()); // RUNNABLE or TIMED_WAITING

        t2.start();
        Thread.sleep(100);

        System.out.println("t2 State (should be BLOCKED): " + t2.getState());

        t1.join();
        t2.join();

        System.out.println("Final State t1: " + t1.getState()); // TERMINATED
        System.out.println("Final State t2: " + t2.getState()); // TERMINATED
    }
}