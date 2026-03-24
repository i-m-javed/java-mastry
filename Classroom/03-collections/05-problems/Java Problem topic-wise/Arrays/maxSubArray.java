package Arrays;

public class maxSubArray {

  
    public int[] getMaxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = 0;
        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < n; i++) {
            if (sum == 0) start = i;

            sum += nums[i];

            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return new int[] { ansStart, ansEnd };
    }


    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray obj = new maxSubArray();
        int[] result = obj.getMaxSubArray(arr);
        System.out.println("Start index: " + result[0] + ", End index: " + result[1]);
        System.out.println("Maximum subarray sum: " + arr[result[0]] + " to " + arr[result[1]]);
    }
}

  
