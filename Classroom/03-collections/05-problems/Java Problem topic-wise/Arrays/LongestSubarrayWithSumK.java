package Arrays;

public class LongestSubarrayWithSumK {


  //Brute Force
  // public static int getLengthOfLongestSubarrayWithSumK(int arr[], int k){

  //   int n = arr.length;
  //   int len = 0;

  //   for(int i = 0; i< n; i++){
  //     int sum = 0;
  //     for(int j = i; j < n; j++){
  //       sum += arr[j];
  //       if(sum == k){
  //         len = Math.max(len, j-i+1);
  //         break;
  //       }
  //       else if(sum > k){
  //         break;
  //       }
  //     }
  //   }

  //   return len;
  // }
  


  //Optimal
  public static int getLongestSubArrayWithSumK(int arr[], int k) {

    int n = arr.length;
    int maxLen = 0;
    int left = 0;
    int right = 0;
    int sum = 0;

    while(right <  n){
      sum += arr[right];
      while(sum > k && left <= right){
        sum -= arr[left];
        left++;
      }
      if(sum == k){
        maxLen = Math.max(maxLen, right-left+1);
      }
      right++;
    }
    return maxLen;
  }


  public static void main(String[] args) {
    int arr[] = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
    System.out.println(getLongestSubArrayWithSumK(arr, 0));
  }
}
