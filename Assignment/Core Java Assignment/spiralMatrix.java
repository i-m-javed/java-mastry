package training;

import java.util.Scanner;

public class spiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n=sc.nextInt();
		System.out.println("Enter number of columns");
		int m=sc.nextInt();
		System.out.println("Enter elements of array");
		int[][] nums= new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				nums[i][j]=sc.nextInt();
			}
		}
		int top=0, bottom=n-1, left=0, right=m-1;
		while(top<=bottom && left<=right) {
			for(int i=left;i<=right;i++) {
				System.out.print(nums[top][i]+ " ");
			}

			top++;
			for(int i=top;i<=bottom;i++) {
				System.out.print(nums[i][right]+ " ");
			}

			right--;
			
			if (top <= bottom) {
			for(int i=right;i>=left;i--) {
				System.out.print(nums[bottom][i]+ " ");
			}
			bottom--;
			}
			
			if (left <= right) {
			for(int i=bottom;i>=top;i--) {
				System.out.print(nums[i][left]+ " ");
			}
			left++;
			}

		}
		
	}

}
