class DemoTask implements Runnable {

    @Override
    public void run() {
        System.out.println(
                "Executing in: " +
                Thread.currentThread().getName()
        );
    }
}

public class StartingThread {

    public static void main(String[] args) {

        System.out.println("Main thread: " +
                Thread.currentThread().getName());

        Runnable task = new DemoTask();

        Thread thread = new Thread(task, "Worker-1");

        System.out.println("\n=== Calling run() directly ===");
        thread.run();  // Executes in main thread

        System.out.println("\n=== Calling start() ===");
        thread.start();  // Executes in new thread

        System.out.println("\n=== Attempting to start thread again ===");

        try {
            thread.start(); // IllegalThreadStateException
        } catch (IllegalThreadStateException e) {
            System.out.println("Exception: Thread cannot be started twice.");
        }

        System.out.println("\n=== Multiple Threads Execution ===");

        Thread t1 = new Thread(task, "Worker-A");
        Thread t2 = new Thread(task, "Worker-B");

        t1.start();
        t2.start();

        System.out.println("\nMain thread continues...");
    }
}