package collection_interface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class hashmap {

  public static void printFrequencyOfElement(int arr[]){

    HashMap<Integer, Integer> freqMap  = new HashMap<>();

    for(int num : arr){
      // map.put(num, map.getOrDefault(num, 0) + 1);
      Integer count = freqMap.get(num);
      if(count == null){
        freqMap.put(num, 1);
      }
      else {
        freqMap.put(num, ++count);
      }
    }

    for(Map.Entry<Integer, Integer> e : freqMap.entrySet()){
      System.out.println(e.getKey() + " : " + e.getValue());
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
