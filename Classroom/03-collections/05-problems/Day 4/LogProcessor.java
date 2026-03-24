import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LogProcessor {

    public static void processLogs(Queue<String> logs) {

        Stack<String> errorStack = new Stack<>();
        String lastError = "";
        int errorCount = 0;

        while (!logs.isEmpty()) {

            String log = logs.poll();
            System.out.println("Processing: " + log);

            if (log.startsWith("ERROR")) {

                if (log.equals(lastError)) {
                    errorCount++;
                } else {
                    errorCount = 1;
                    lastError = log;
                }

                if (errorCount == 3) {
                    System.out.println("ALERT: Same ERROR occurred 3 times.");
                    return;
                }

                errorStack.push(log);

                // Immediate reprocess
                System.out.println("Reprocessing: " + errorStack.pop());
            } else {
                errorCount = 0;
                lastError = "";
            }
        }
    }

    public static void main(String[] args) {

        Queue<String> logs = new LinkedList<>();
        logs.add("INFO:Start");
        logs.add("ERROR:DiskFull");
        logs.add("ERROR:DiskFull");
        logs.add("ERROR:DiskFull");
        logs.add("INFO:End");

        processLogs(logs);
    }
}