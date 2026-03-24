package Arrays;


public class LowerBound {
  public static void main(String[] args) {
    int nums[] = {1,2, 3, 4, 5, 6, 7, 8,9};
    System.out.println(getLowerBound(nums, 5));
    System.out.println(getUpperBound(nums, 5));
  }

  public static int getLowerBound(int nums[], int x){
    int n = nums.length;
    int ans = n;
    int low = 0; 
    int high = n-1;
    while(low <= high){
      int mid = (low+high)/2;
      if(nums[mid] >= x){
        ans = mid;
        high = mid-1;
      }
      else low = mid+1;
    }
    return ans;
  }
  public static int getUpperBound(int nums[], int x){
    int n = nums.length;
    int ans = n;
    int low = 0; 
    int high = n-1;
    while(low <= high){
      int mid = (low+high)/2;
      if(nums[mid] > x){
        ans = mid;
        high = mid-1;
      }
      else low = mid+1;
    }
    return ans;
  }
}
