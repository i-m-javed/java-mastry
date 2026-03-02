import java.util.HashMap;

public class LongestSubarraySumK {

    public static void findSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        int startIndex = -1, endIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLength = i + 1;
                startIndex = 0;
                endIndex = i;
            }

            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);

                if (length > maxLength) {
                    maxLength = length;
                    startIndex = map.get(prefixSum - k) + 1;
                    endIndex = i;
                }
            }

            map.putIfAbsent(prefixSum, i);
        }

        if (maxLength > 0) {
            System.out.println("Longest Subarray Length: " + maxLength);
            System.out.println("Start Index: " + startIndex);
            System.out.println("End Index: " + endIndex);
        } else {
            System.out.println("No subarray found.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};
        int k = 6;

        findSubarrays(arr, k);
    }
}