import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {

    private Task task;
    private long startTime;

    public DelayedTask(Task task, long delayMillis) {
        this.task = task;
        this.startTime = System.currentTimeMillis() + delayMillis;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.startTime, ((DelayedTask) o).startTime);
    }
}
