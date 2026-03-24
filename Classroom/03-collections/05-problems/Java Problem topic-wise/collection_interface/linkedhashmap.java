package collection_interface;
import java.util.*;

public class linkedhashmap {

  public static void printFrequencyOfElement(int arr[]){

    LinkedHashMap<Integer, Integer> freqMap  = new LinkedHashMap<>();

    for(int num : arr){
      Integer count = freqMap.get(num);
      if(count == null){
        freqMap.put(num, 1);
      }
      else {
        freqMap.put(num, ++count);
      }
    }

    for(Map.Entry<Integer, Integer> e : freqMap.entrySet()){
      System.out.println(e.getKey() + " : " + e.getKey());
    }


  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n = sc.nextInt();

    int arr[] = new int[n];

    System.out.println("Enter the element: ");
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    for(int var: arr){
      System.out.println(var);
    }

    printFrequencyOfElement(arr);

    sc.close();

  }
}
