public class IncrementDecrement {
  public static void main(String[] args) {
    int a = 10;
    System.out.println("Initial value of a: " + a);

    // Pre-increment
    System.out.println("Pre-increment: " + ++a);
    System.out.println("Value after pre-increment: " + a);

    // Post-increment
    System.out.println("Post-increment: " + a++);
    System.out.println("Value after post-increment: " + a);

    // Pre-decrement
    System.out.println("Pre-decrement: " + --a);
    System.out.println("Value after pre-decrement: " + a);

    // Post-decrement
    System.out.println("Post-decrement: " + a--);
    System.out.println("Value after post-decrement: " + a);
  }
}
