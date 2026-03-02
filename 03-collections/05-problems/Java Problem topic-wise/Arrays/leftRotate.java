package Arrays;

public class leftRotate {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int temp[] = new int[k];

        for(int i = 0; i < k; i++){
            temp[i] = nums[i];
        }

        for(int i = k; i < n; i++){
            nums[i-k] = nums[i];
        }

        for(int i = n-k; i < n; i++){
            nums[i] = temp[i-(n-k)];
        }

        for(int i : nums){
            System.out.print(i + " ");
        }
    }   


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        leftRotate obj = new leftRotate();
        obj.rotateArray(arr, 3);
    }
}
  

