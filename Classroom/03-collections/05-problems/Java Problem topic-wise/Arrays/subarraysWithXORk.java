package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subarraysWithXORk {

  //Brute force or better 
  public static int getXORcount(int nums[], int k) {
    int n = nums.length;
    int count = 0;


    for(int i = 0; i < n; i++){
      int res = 0;
      for(int j = i; j < n; j++){
        res ^= nums[j];
        if(res == k) count++;
      }
    }

    return count;
  }

  public static int countSubarraysWithXor(int[] arr, int K) {
        int count = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // for subarrays that start from index 0

        for (int num : arr) {
            xor ^= num;

            int required = xor ^ K;
            count += map.getOrDefault(required, 0);

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    
  public static void main(String... args){
    int nums[] = {4, 2, 2, 6, 4};
    System.out.println(getXORcount(nums, 6));
    System.out.println(countSubarraysWithXor(nums, 6));
    
  }
}
