import  java.util.Scanner;
public class ArrayInput {
  public static void main(String[] args) {
    // Declare an array to hold 5 integers
    int[] numbers = new int[5];

    // Input values into the array using a loop
    Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Enter 5 integers:");
    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = scanner.nextInt();
    }

    // Display the entered values
    System.out.println("You entered:");
    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i]);
    }

    // Close the scanner
    scanner.close();
  }
  
}
