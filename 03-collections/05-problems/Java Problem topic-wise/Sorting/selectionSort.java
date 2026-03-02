package Sorting;
import java.util.Arrays;

public class selectionSort {


  public static void swap(int  []arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  
  public static int[] getSelectionSort(int [] arr){

    for(int i = 0; i <= arr.length-2; i++){
      int min_index = i;
      for(int j = i+1; j<= arr.length-1; j++ ){
        if(arr[j] < arr[min_index]) min_index = j;
      }
      swap(arr, i, min_index);
    }

    return arr;

    // for (int i : arr) {
    //     System.out.println(i);
    // }
  }
  public static void main(String[] args) {
    int arr[] = {1, 2, 4, 3,7, 5};
    int sortedArr[] = getSelectionSort(arr);

    System.out.println(Arrays.toString(sortedArr));

  }
}
