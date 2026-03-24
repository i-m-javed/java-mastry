package training;

import java.util.Scanner;
import java.util.Stack;

public class browserAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> previous= new Stack<>();
		Stack<String> next= new Stack<>();
		boolean run=true;
		Scanner sc= new Scanner(System.in);
		String crr="";
		
		while(run) {
			System.out.println(" Press < to go back, > to go forward, + to open new page, x to exit ");
			String action= sc.next().trim();
			if(action.equals("<")) {
				if(previous.isEmpty()) {
					System.out.println("No previous page available");
					if(!crr.equals("")) {
						System.out.println("You are on "+crr+" page");
					}
				}else {
					next.push(crr);
					crr=previous.pop();
					System.out.println("You are on "+crr+" page");
				}
			}else if(action.equals(">")) {
				if(next.isEmpty()) {
					System.out.println("No next page available");
					if(!crr.equals("")) {
						System.out.println("You are on "+crr+" page");
					}
				}else {
					previous.push(crr);
					crr=next.pop();
					System.out.println("You are on "+crr+" page");
				}
			}else if(action.equals("+")){
				System.out.println("Enter page name");
				if(!crr.equals("")) {
					previous.push(crr);
					next.clear();
				}
				crr=sc.next().trim();
				System.out.println("You are on "+crr+" page");
			}else if(action.equals("x")) {
				run=false;
			}
		}
		System.out.println("Exits from browser");
	}

}
