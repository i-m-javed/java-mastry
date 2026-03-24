package training;

import java.util.LinkedList;
import java.util.Queue;

public class logProcessing {
	public static void main(String[] args) {
		log l= new log();
		l.addLog("INFO:Start");
        l.addLog("ERROR:DiskFull");
        l.addLog("WARN:LowMemory");
        l.addLog("ERROR:DiskFull");
        l.process();
	}
}

class log {
	Queue<String> logQueue = new LinkedList<>();

	public void addLog(String msg) {
		logQueue.offer(msg);
	}
	String pre=null;
	int count=0;
	public void process() {
		while(!logQueue.isEmpty()) {
			String crr= logQueue.poll();
			if(crr.startsWith("ERROR")){
				if(pre != null && pre.equals(crr)) {
					count++;
					if(count==3) {
						System.out.println("!ALERT");
						System.exit(0);
					}
				}else {
					System.out.println(crr);
					pre=crr;
					count=1;
					addLog(crr);
				}
			}else {
				System.out.println(crr);
				pre=null;
				count=0;
			}
		}
	}
}