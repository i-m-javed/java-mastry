package Recursion;

public class countDigit {
    public static int getCountDigit(int n) {
        if( n == 0) return 0;
        return 1+getCountDigit(n/10);
    }
    
    public static void main(String[] args) {
        System.out.println(getCountDigit(1));
    }
}
