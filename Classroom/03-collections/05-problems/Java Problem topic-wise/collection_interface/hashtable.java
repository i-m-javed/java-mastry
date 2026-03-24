package collection_interface;
import java.util.Hashtable;
import java.util.Map;
import java.util.Iterator;



public class hashtable {
  public static void main(String[] args) {
    
    // Map<String, Integer> ht1 = new Hashtable<>();
    Hashtable<String, Integer> ht1 = new Hashtable<>();
    ht1.put("Javed", 90);
    ht1.put("Mohan", 60);
    ht1.put("Shayam", 70);
    ht1.put("Javed", 95); // changing
    ht1.remove("Mohan");



    // System.out.println(ht1.get("Javed")); // 90


    Hashtable<String, Integer> ht2 = new Hashtable<>(ht1);
    ht2.put("Ali", 50); 

    System.out.println(ht2.size()); // length
    System.out.println(ht2); 
    System.out.println(ht1);

    //iteration

    for(Map.Entry<String, Integer> e : ht1.entrySet()){
      System.out.println("Key: " + e.getKey() + ", Value:  "+e.getValue());
    }

    Iterator<String> iterator = ht2.keySet().iterator();
    while(iterator.hasNext()){
      String key = iterator.next();
      Integer val = ht2.get(key);
      System.out.println("Key: "+ key +", Value:"+ val);
    }

    
  }
}
