package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bubbleSort {
  public static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr){

    for(int i = 0; i < arr.size(); i++){
      for(int j = i+1; j < arr.size(); j++){
        if(arr.get(j) < arr.get(i)){
          Collections.swap(arr, i, j);
        }
      }
    }

    return arr;
  }



  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 4, 2, 7, 4));
    System.out.println(bubble_sort(arr));
    int num[] = {1, 3, 4, 2, 7, 4};
    int sortedArr[] = Sorting.insertionSort.insertion_sort(num);
    System.out.println("Insertion sort: ");
    System.out.println(Arrays.toString(sortedArr));
  }

}
