package training;

import java.util.Scanner;

public class longestSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter elements of array");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter target sum");
		int target=sc.nextInt();
		int i=0,j=0;
		int crr=0;
		int start=0,end=-1;
		while(i<n&&j<n) {
			crr+=arr[j];
			while(i<n&& crr>target) {
				crr-=arr[i];
				i++;
			}
			if((crr==target)&&((end-start+1)<=(j-i+1))) {
				start=i;
				end=j;
			}
			j++;
		}
		if(end==-1) {
			System.out.println("No subarray with sum "+target+" exist");
		} else {
			for(int k=start;k<=end;k++) {
				System.out.print(arr[k]+" ");
			}
		}
	}

}
