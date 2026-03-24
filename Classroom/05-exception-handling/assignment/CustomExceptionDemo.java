// base class
class AgeValidator {
  public void validateAge(int age) {
    if (age < 18) {
      throw new InvalidAgeExcpetion("Age must be 18 or above");
    }
    System.out.println("Valid Age");
  }
}

// child class
class InvalidAgeExcpetion extends RuntimeException {
  public InvalidAgeExcpetion(String message) {
    super(message);
  }
}


// runtime --> unchecked --> extends RuntimeException --> base class no signature need
// complile --> checked -->  extends Exception --> base class signature needed

public class CustomExceptionDemo {

  static void main() {
    int age = 17;
    AgeValidator ag = new AgeValidator();
    try {
      ag.validateAge(age);
      System.out.println("hhheloo");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
