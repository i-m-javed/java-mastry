
public class BitwiseOperators {
  public static void main(String[] args) {
    int a = 5;  // 0101 in binary
    int b = 3;  // 0011 in binary

    System.out.println("a & b = " + (a & b));   // Bitwise AND
    System.out.println("a | b = " + (a | b));   // Bitwise OR
    System.out.println("a ^ b = " + (a ^ b));   // Bitwise XOR
    System.out.println("~a = " + (~a));         // Bitwise NOT
    System.out.println("b << 1 = " + (b << 1)); // Left shift
    System.out.println("b >> 1 = " + (b >> 1)); // Right shift
  }
  
}
