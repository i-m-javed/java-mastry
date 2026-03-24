package others;
import java.util.Scanner;
public class gcd {
  public static void main(String[] args) {

		System.out.println("Enter two number: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
    sc.close();
		System.out.println(getGCD(a, b));
	}
	
	public static int getGCD(int a, int b){

    while(a > 0 && b > 0){
      if(a > b) a = a % b;
      else b = b % a;
    }

	if(a == 0) return b;
	return a;
  }
}
