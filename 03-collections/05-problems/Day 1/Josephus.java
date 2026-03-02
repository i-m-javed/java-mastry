public class Josephus {

    // Iterative Solution (Efficient)
    public static int findSurvivor(int n, int k) {
        int result = 0;  // base case for n = 1

        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        return result + 1; // Convert to 1-based index
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 2;

        System.out.println("Survivor: " + findSurvivor(n, k));
    }
}