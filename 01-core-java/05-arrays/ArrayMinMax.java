
public class ArrayMinMax {
  public static void main(String[] args) {
    int[] numbers = {10, 20, 30, 40, 50};
    int min = numbers[0];
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
      }
      if (numbers[i] > max) {
        max = numbers[i];
      }
    }
    System.out.println("Minimum value: " + min);
    System.out.println("Maximum value: " + max);
  }
}