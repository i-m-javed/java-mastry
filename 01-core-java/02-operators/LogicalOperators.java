
public class LogicalOperators {
  
    public static void main(String[] args) {

        int age = 25;
        boolean hasLicense = true;

        System.out.println("Eligible to drive: " + (age >= 18 && hasLicense));
        System.out.println("Teenager: " + (age >= 13 && age <= 19));
        System.out.println("Not eligible: " + !(age >= 18));
    }

  }
  
