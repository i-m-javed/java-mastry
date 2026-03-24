public class SecondLargest {

    public static int findSecondLargest(int[] arr) {

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new RuntimeException("No second largest element");
        }

        return second;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 20};
        System.out.println("Second Largest: " + findSecondLargest(arr));
    }
}