package training;

import java.util.Scanner;

public class squareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a positive number");
		int n=sc.nextInt();
		int low=0, high=n/2;
		double ans=0;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(mid==n/mid) {
				ans=mid;
				break;
			}else if(mid*mid>n) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		while(ans*ans<n) {
			double temp=ans+0.1;
			if(temp*temp<=n) {
				ans=temp;
			}else {
				break;
			}
		}
		System.out.println(ans);
	}

}
