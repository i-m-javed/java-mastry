package training;

import java.util.Scanner;

public class primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a positive number");
		int n=sc.nextInt();
		if(n==1||n==2) {
			System.out.println("Not a prime number");
		}
		boolean isPrime= true;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime) {
			System.out.println("Prime number");
		} else {
			System.out.println("Not a prime number");
		}
	}

}
