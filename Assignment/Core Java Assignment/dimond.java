package training;

public class dimond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(4);
	}
	public static void print(int star) {
		int n=star*2+1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0||j==0||i==n-1||j==n-1) {
					System.out.print("*");
				} else if (Math.abs(i - star) + Math.abs(j - star) == star) {
                    System.out.print("*");
                } else {
                	System.out.print(" ");
                }
			}
			System.out.println();
		}
	}
}
