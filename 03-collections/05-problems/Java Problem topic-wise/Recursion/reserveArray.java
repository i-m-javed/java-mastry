package Recursion;
import java.util.*;

public class reserveArray {


  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  

  public static void reverse(int i, int[] arr) {
    int n = arr.length;
    if (i >= n / 2)
      return;
    
    reverse(i + 1, arr);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arr[] = new int[5];
    
    System.out.println("Enter 5 integers:");
    for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
    }
    
    reverse(0, arr);
    
    System.out.println("Reversed array:");
    for (int num : arr) {
        System.out.print(num + " ");
    }
    sc.close();
  }

}

