package others;

import java.util.Scanner;
import java.lang.Math;
public class countDigit {
  public static void main(String...args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        long n = sc.nextLong();

        if (n == 0) {
            System.out.println(1); // Zero has 1 digit
        } else {
            n = Math.abs(n); // Handle negative numbers
            int countDigit = (int) Math.log10(n) + 1;
            System.out.println(countDigit);
        }
        sc.close();
  }
}
