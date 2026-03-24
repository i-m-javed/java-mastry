public class PreventingThreadExecution {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker started");

                System.out.println("Worker sleeping...");
                Thread.sleep(2000); // TIMED_WAITING

                System.out.println("Worker woke up");

                Thread.yield(); // Hint to scheduler
                System.out.println("Worker after yield");

            } catch (InterruptedException e) {
                System.out.println("Worker interrupted during sleep");
                Thread.currentThread().interrupt();
            }
        }, "Worker-Thread");

        worker.setPriority(Thread.MAX_PRIORITY);

        worker.start();

        System.out.println("Main thread waiting using join()");
        worker.join(); // WAITING

        System.out.println("Worker finished");

        System.out.println("\n=== Interrupt Demo ===");

        Thread interruptThread = new Thread(() -> {
            try {
                System.out.println("Interrupt thread sleeping...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Interrupt detected!");
            }
        });

        interruptThread.start();

        Thread.sleep(1000);
        interruptThread.interrupt();

        interruptThread.join();

        System.out.println("Main thread completed");
    }
}