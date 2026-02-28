
public class TernaryOperator {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;

    // Using ternary operator to find the maximum of two numbers
    int max = (a > b) ? a : b;
    System.out.println("Maximum: " + max); // Output: 20

    // Using ternary operator to check if a number is even or odd
    int number = 15;
    String result = (number % 2 == 0) ? "Even" : "Odd";
    System.out.println(number + " is " + result); // Output: 15 is Odd
  }
  
}
