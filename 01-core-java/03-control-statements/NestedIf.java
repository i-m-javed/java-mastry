public class NestedIf {
  public static void main(String[] args) {
        int age = 25;
        boolean hasID = true;

        if (age >= 18) {
            if (hasID) {
                System.out.println("Eligible to vote");
            } else {
                System.out.println("Not eligible to vote - ID required");
            }
        } else {
            System.out.println("Not eligible to vote - Age requirement not met");
        }
  }
}
