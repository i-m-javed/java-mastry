package Arrays;

public class largestElement {

  public static int getLargestNumber(int arr[]){
    int largest = arr[0];
    for(int i = 0; i < arr.length; i++){
      if(arr[i] > largest){
        largest = arr[i];
      }
    }

    return largest;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 9, 4, 5};
    System.out.println(getLargestNumber(arr));
  }
  
}
