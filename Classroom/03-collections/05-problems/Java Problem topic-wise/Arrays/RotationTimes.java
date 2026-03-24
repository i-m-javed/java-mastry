package Arrays;

public class RotationTimes {
  public static void main(String[] args) {
    RotationTimes rt = new RotationTimes();
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int times = rt.findMin(nums);
    System.out.println("Minimum rotation times is: " + times);
  }
  public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[mid]){
              if(nums[low] < min) {
                  index = low;
                  low = mid + 1;
              }
            }
            else {
                if(nums[mid] < min) {
                    index = mid;
                    high = mid-1;
                }
                
            }
        }
        return index;
    }
}

