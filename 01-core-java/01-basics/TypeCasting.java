public class TypeCasting {
  public static void main(String[] args) {
    // Implicit Casting (Widening)
    int i = 100;
    long l = i; // int to long
    float f = l; // long to float

    System.out.println("Implicit Casting:");
    System.out.println("Int: " + i);
    System.out.println("Long: " + l);
    System.out.println("Float: " + f);

    // Explicit Casting (Narrowing)
    double d = 9.99;
    int j = (int) d; // double to int

    System.out.println("\nExplicit Casting:");
    System.out.println("Double: " + d);
    System.out.println("Int: " + j);
    
  }
  
}
