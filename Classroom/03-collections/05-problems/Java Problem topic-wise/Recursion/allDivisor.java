package Recursion;
import java.util.*;

public class allDivisor {
    public static void main(String[] args) {

      System.out.println("Enter the number:");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.close();

      ArrayList<Integer> num = new ArrayList<>();

      for (int i = 1; i * i <= n; i++) {
          if (n % i == 0) {
              num.add(i);
              if (n / i != i) {
                  num.add(n / i);
              }
          }
      }

      Collections.sort(num);

      System.out.println("Divisors are : ");
      System.out.println(num);
      
    }
}


