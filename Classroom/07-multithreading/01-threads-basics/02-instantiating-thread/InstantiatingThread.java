class SharedTask implements Runnable {

    private int counter = 0;

    @Override
    public void run() {
        counter++;
        System.out.println(
                Thread.currentThread().getName() +
                " Counter: " + counter
        );
    }
}

public class InstantiatingThread{

    public static void main(String[] args) {

        System.out.println("Main thread: " +
                Thread.currentThread().getName());

        System.out.println("\n=== Instantiating Thread with Runnable ===");

        SharedTask task = new SharedTask();

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        System.out.println("Threads instantiated but not started yet.");

        System.out.println("\n=== Starting Threads ===");

        t1.start();
        t2.start();

        System.out.println("\n=== Instantiating Thread by Extending Thread ===");

        Thread t3 = new Thread(() ->
                System.out.println(
                        "Lambda Thread: " +
                        Thread.currentThread().getName()
                ),
                "Lambda-Worker"
        );

        t3.start();

        System.out.println("\nMain thread continues execution...");
    }
}