class SharedBuffer {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {

        while (hasData) {
            wait();  // WAITING
        }

        data = value;
        hasData = true;

        System.out.println("Produced: " + value);

        notifyAll(); // Notify consumers
    }

    public synchronized int consume() throws InterruptedException {

        while (!hasData) {
            wait();  // WAITING
        }

        int value = data;
        hasData = false;

        System.out.println("Consumed: " + value);

        notifyAll(); // Notify producer

        return value;
    }
}

public class ThreadInteraction{

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}