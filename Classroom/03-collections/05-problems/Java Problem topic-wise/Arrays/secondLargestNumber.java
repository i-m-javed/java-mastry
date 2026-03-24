package Arrays;

public class secondLargestNumber {
  public static int getSecondLargestNumber(int arr[]){
    
    int largest = arr[0];
    int secondLargest = -1;
    
    for(int i = 1; i < arr.length; i++){
        if(arr[i] > largest){
          secondLargest = largest;
          largest = arr[i];
        }
        else if(arr[i] < largest && arr[i] > secondLargest ){
          secondLargest = arr[i];
        }
      }
  
    return secondLargest;
  }

  // public static int getSecondLargestNumber(int []arr){
  //   int secondLargest = -1;
  //   int largest = Arrays.largestElement.getLargestNumber(arr);
  //   for(int i = 0; i< arr.length; i++){
  //     if( arr[i] > secondLargest && arr[i] != largest){
  //       secondLargest = arr[i];
  //     }
  //   }
  //   return secondLargest;
  // }

  public static void main(String[] args) {
    int arr[] = {1, 1, 1 ,2};
    System.out.println(getSecondLargestNumber(arr));
  }
}
