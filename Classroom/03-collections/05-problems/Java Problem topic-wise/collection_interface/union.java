package collection_interface;

import java.util.*;

public class union {

  public int[] unionArray(int[] nums1, int[] nums2) {


    TreeSet<Integer> unionSet = new TreeSet<>();

    for (int num : nums1) {
        unionSet.add(num);
    }

    for (int num : nums2) {
        unionSet.add(num);
    }

    int[] res = new int[unionSet.size()];
    
    int i = 0;
    for (int num : unionSet) {
        res[i++] = num;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {2, 4, 6};
    union obj = new union();
    System.out.println(Arrays.toString(obj.unionArray(nums1, nums2)));
  }
}

