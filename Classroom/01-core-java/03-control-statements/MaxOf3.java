public class MaxOf3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 1;
        int c = 7;
        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("Maximum : " + max);
    }
}
