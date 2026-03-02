package Arrays;

public class isSorted {
  public static boolean getIsSorted(int a[]){


    for(int i = 1; i < a.length; i++){
      if(a[i-1]  > a[i]){ // moment when prev > current
        return false;
      }
    }

    return true;
  }

  public static void main(String... args){
    int arr[] = {1, 2, 3,3,5,6};
    System.out.println(getIsSorted(arr));
  }
}
