package Sorting;
import java.util.Arrays;

public class insertionSort {

    public static int[] insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7, 4};
        int[] sortedArr = insertion_sort(arr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
