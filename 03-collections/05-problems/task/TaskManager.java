import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class TaskManager {

    private static final int MAX_QUEUE_SIZE = 10;

    private Queue<Task> pendingQueue = new LinkedList<>();
    private Queue<Task> inProgressQueue = new LinkedList<>();
    private Queue<Task> completedQueue = new LinkedList<>();
    private Queue<Task> backlogQueue = new LinkedList<>();

    private PriorityQueue<Task> priorityQueue =
            new PriorityQueue<>();

    private DelayQueue<DelayedTask> delayedQueue =
            new DelayQueue<>();

    private Queue<String> auditLog = new LinkedList<>();

    private Stack<Runnable> undoStack = new Stack<>();
    private Stack<Runnable> redoStack = new Stack<>();

    private Map<Integer, Task> allTasks = new HashMap<>();

    // ---------------- ADD TASK ----------------
    public void addTask(Task task) {

        if (allTasks.containsKey(task.getId()))
            throw new IllegalArgumentException("Duplicate Task ID");

        if (pendingQueue.size() >= MAX_QUEUE_SIZE) {
            backlogQueue.offer(task);
            auditLog.offer("Task moved to backlog: " + task.getId());
            return;
        }

        pendingQueue.offer(task);
        priorityQueue.offer(task);
        allTasks.put(task.getId(), task);

        auditLog.offer("Task created: " + task.getId());

        undoStack.push(() -> removeTask(task.getId()));
        redoStack.clear();
    }
    
    public void removeTask(int taskId) {
    Task task = allTasks.remove(taskId);
    if (task == null) {
        return;
    }

    pendingQueue.remove(task);
    inProgressQueue.remove(task);
    completedQueue.remove(task);
    backlogQueue.remove(task);
    priorityQueue.remove(task);

    auditLog.offer("Task removed: " + taskId);
}



    // ---------------- COMPLETE TASK ----------------
    public void completeTask() {
        Task task = pendingQueue.poll();
        if (task == null) return;

        task.setStatus(TaskStatus.COMPLETED);
        completedQueue.offer(task);
        priorityQueue.remove(task);

        auditLog.offer("Task completed: " + task.getId());

        undoStack.push(() -> {
            completedQueue.remove(task);
            task.setStatus(TaskStatus.PENDING);
            pendingQueue.offer(task);
        });
    }

    // ---------------- VIEW TASKS ----------------
    public void viewPendingTasks() {
        pendingQueue.forEach(System.out::println);
    }

    // ---------------- PRIORITY PROCESSING ----------------
    public Task processHighestPriorityTask() {
        Task task = priorityQueue.poll();
        if (task != null) {
            pendingQueue.remove(task);
            inProgressQueue.offer(task);
            task.setStatus(TaskStatus.IN_PROGRESS);
        }
        return task;
    }

    // ---------------- SEARCH ----------------
    public Task searchById(int id) {
        return allTasks.get(id);
    }

    // ---------------- AGING & ESCALATION ----------------
    public void escalateOldTasks(long minutes) {
        for (Task task : pendingQueue) {
            Duration d = Duration.between(task.getCreatedTime(), LocalDateTime.now());
            if (d.toMinutes() > minutes && task.getPriority() > 1) {
                task.setPriority(task.getPriority() - 1);
                auditLog.offer("Priority escalated: " + task.getId());
            }
        }
    }

    // ---------------- SERIALIZATION ----------------
    public void saveState() throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            oos.writeObject(pendingQueue);
            oos.writeObject(completedQueue);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadState() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            pendingQueue = (Queue<Task>) ois.readObject();
            completedQueue = (Queue<Task>) ois.readObject();
        }
    }

    // ---------------- AUDIT LOG ----------------
    public void showAuditLog() {
        auditLog.forEach(System.out::println);
    }
}
