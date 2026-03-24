import java.util.Scanner;

public class TodoApp {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n====== TODO APPLICATION ======");
            System.out.println("1. Add Task");
            System.out.println("2. View Pending Tasks");
            System.out.println("3. Complete Task (FIFO)");
            System.out.println("4. Process Highest Priority Task");
            System.out.println("5. Search Task by ID");
            System.out.println("6. View Audit Log");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {

                case 1 -> addTaskUI(manager, sc);

                case 2 -> {
                    System.out.println("\nPending Tasks:");
                    manager.viewPendingTasks();
                }

                case 3 -> {
                    manager.completeTask();
                    System.out.println("Task completed (FIFO).");
                }

                case 4 -> {
                    Task t = manager.processHighestPriorityTask();
                    if (t != null)
                        System.out.println("Processing: " + t);
                    else
                        System.out.println("No tasks available.");
                }

                case 5 -> {
                    System.out.print("Enter Task ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Task task = manager.searchById(id);
                    System.out.println(task != null ? task : "Task not found.");
                }

                case 6 -> manager.showAuditLog();

                case 7 -> {
                    running = false;
                    System.out.println("Exiting TODO App...");
                }

                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    private static void addTaskUI(TaskManager manager, Scanner sc) {
        try {
            System.out.print("Enter Task ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Description: ");
            String desc = sc.nextLine();

            System.out.print("Enter Priority (1=High, 2=Medium, 3=Low): ");
            int priority = Integer.parseInt(sc.nextLine());

            Task task = new Task(id, desc, priority);
            manager.addTask(task);

            System.out.println("Task added successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
