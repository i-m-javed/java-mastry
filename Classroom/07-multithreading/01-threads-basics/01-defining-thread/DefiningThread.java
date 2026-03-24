class ExtendingThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println(
                "ExtendingThreadExample running on: " +
                Thread.currentThread().getName()
        );
    }
}

class RunnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println(
                "RunnableTask running on: " +
                Thread.currentThread().getName()
        );
    }
}

public class DefiningThread {

    public static void main(String[] args) {

        System.out.println("Main thread: " +
                Thread.currentThread().getName());

        System.out.println("\n=== Defining Thread by Extending Thread ===");
        Thread t1 = new ExtendingThreadExample();
        t1.start();

        System.out.println("\n=== Defining Thread by Implementing Runnable ===");
        RunnableTask task = new RunnableTask();
        Thread t2 = new Thread(task);
        t2.start();

        System.out.println("\n=== Defining Thread using Lambda ===");
        Thread t3 = new Thread(() ->
                System.out.println(
                        "Lambda task running on: " +
                        Thread.currentThread().getName()
                )
        );
        t3.start();

        System.out.println("\n=== Calling run() directly (No new thread) ===");
        t3.run(); // Runs in main thread

        System.out.println("\nMain thread continues...");
    }
}