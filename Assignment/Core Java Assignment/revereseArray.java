package training;

import java.util.Scanner;

public class revereseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int len= sc.nextInt();
		int arr[]= new int[len];
		System.out.println("Enter values of array ");
		for(int i=0;i<len;i++) {
			arr[i]=sc.nextInt();
		}
		int i=0,j=len-1;
		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;j--;
		}
		for(int k=0;k<len;k++) {
			System.out.println(arr[k]);
		}
	}

}
