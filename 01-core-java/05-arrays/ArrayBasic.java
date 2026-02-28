public class ArrayBasic {
  public static void main(String[] args) {
    // Declare and initialize an array of integers
    int[] numbers = {10, 20, 30, 40, 50};

    // Accessing elements of the array
    System.out.println("First element: " + numbers[0]); // Output: 10
    System.out.println("Third element: " + numbers[2]); // Output: 30

    // Modifying an element in the array
    numbers[1] = 25;
    System.out.println("Modified second element: " + numbers[1]); // Output: 25

    // Looping through the array to traverse and print all elements
    System.out.println("All elements in the array:");
    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i]);
    }
  }
  
}
