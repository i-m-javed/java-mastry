

public class AllInOne {

  public static void main(String[] args) {
        int a = 10;
        int b = 3;
        boolean x = true;
        boolean y = false;
        System.out.println("The value of a and b intiallly are 10 and 3 respectively. \n ");
        System.out.println("---- Arithmetic Operators ----");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + a * b);
        System.out.println("a / b = " + a / b);
        System.out.println("a % b = " + a % b);
        System.out.println("\n---- Unary Operators ----");
        int var10001 = a++;
        System.out.println("Post-increment a++ = " + var10001);
        System.out.println("After increment a = " + a);
        --a;
        System.out.println("Pre-decrement --a = " + a);
        System.out.println("Unary minus -a = " + -a);
        System.out.println("Logical NOT !x = " + !x);
        System.out.println("\n---- Relational Operators ----");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("\n---- Logical Operators ----");
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x     : " + !x);
        System.out.println("\n---- Assignment Operators ----");
        int c = 5;
        c += 3;
        System.out.println("c += 3 : " + c);
        c -= 2;
        System.out.println("c -= 2 : " + c);
        c *= 2;
        System.out.println("c *= 2 : " + c);
        c /= 2;
        System.out.println("c /= 2 : " + c);
        c %= 2;
        System.out.println("c %= 2 : " + c);
        System.out.println("\n---- Bitwise operators ----");
        System.out.println("a & b  = " + (a & b));
        System.out.println("a | b  = " + (a | b));
        System.out.println("a ^ b  = " + (a ^ b));
        System.out.println("~a     = " + ~a);
        System.out.println("\n---- Conditional Operator ----");
        int max = a > b ? a : b;
        System.out.println("Max value = " + max);
        System.out.println("\n---- Shift Operators ----");
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("a >>> 1 = " + (a >>> 1));
    }
}
