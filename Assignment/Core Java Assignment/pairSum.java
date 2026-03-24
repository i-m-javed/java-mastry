package training;

import java.util.Scanner;

public class pairSum {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int len= sc.nextInt();
		int arr[]= new int[len];
		System.out.println("Enter values of array ");
		for(int i=0;i<len;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter target");
		int target=sc.nextInt();
		int count=0;
		boolean used[]= new boolean[len];
		for(int i=0;i<len-1;i++) {
			if(used[i]) {
				continue;
			}
			for(int j=i+1;j<len;j++) {
				if(!used[j]) {
					if(arr[i]+arr[j]==target) {
						System.out.println(arr[i]+" "+arr[j]);
						used[j]=true;
						used[i]=true;
						count++;
						break;
					}
				}
			}
		}
		System.out.println("total count is"+count);
	}
}
