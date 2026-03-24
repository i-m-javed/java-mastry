import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {
    public static int findSecondHighest(int[] arr) {
        return Arrays.stream(arr)
                .distinct()     // remove duplicate
                .boxed()        // Convert intStream to Stream<Integer>
                .sorted(Comparator.reverseOrder()) // sort descending
                .skip(1) // skip highest
                .findFirst()// get second highest
                .orElse(-1); // return -1 of not found
    }

    static void main() {
        int[] arr1 = {10, 20, 5, 20, 8};
        System.out.println(Arrays.toString(arr1) + " -> " + findSecondHighest(arr1));

    }
}
