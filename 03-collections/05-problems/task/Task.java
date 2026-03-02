5import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Task implements Serializable, Comparable<Task> {

    private int id;
    private String description;
    private int priority; // 1 = HIGH, 2 = MEDIUM, 3 = LOW
    private TaskStatus status;
    private LocalDateTime createdTime;
    private Set<Integer> dependencies = new HashSet<>();

    public Task(int id, String description, int priority) {
        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be empty");

        if (priority < 1 || priority > 3)
            throw new IllegalArgumentException("Invalid priority");

        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
        this.createdTime = LocalDateTime.now();
    }

    public int getId() { return id; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public Set<Integer> getDependencies() { return dependencies; }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }

    @Override
    public String toString() {
        return "[ID=" + id +
                ", Desc=" + description +
                ", Priority=" + priority +
                ", Status=" + status + "]";
    }
}
