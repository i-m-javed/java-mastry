public class ScannerExample {
  public static void main(String[] args) {
    // Create a Scanner object to read input from the console
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    // Prompt the user for their name
    System.out.print("Enter your name: ");
    String name = scanner.nextLine(); // Read a line of text

    // Prompt the user for their age
    System.out.print("Enter your age: ");
    int age = scanner.nextInt(); // Read an integer

    // Display the input back to the user
    System.out.println("Hello, " + name + "! You are " + age + " years old.");

    // Close the scanner to free resources
    scanner.close();
  }
  
}
