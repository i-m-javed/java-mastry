package Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Leaders {
    public static ArrayList<Integer> leader(int[] nums) {
        ArrayList<Integer> leader = new ArrayList<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = n-1; i>= 0; i--){
            if(nums[i] > max){
                max = nums[i];
                leader.add(nums[i]);
            }
        }

        Collections.reverse(leader);

        return leader;
    }

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> result = leader(arr);
        System.out.println(result);
    }
}