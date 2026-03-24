public class BreakContinue {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      if (i == 5) {
        continue; // Skip the rest of the loop body when i is 5
      }
      if (i == 8) {
        break; // Exit the loop when i is 8
      }
      System.out.println("i = " + i);
    }
  }
}
