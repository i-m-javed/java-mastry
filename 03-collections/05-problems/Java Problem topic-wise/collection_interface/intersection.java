package collection_interface;
import java.util.*;
import java.util.Arrays;
public class intersection {
  
  public static HashSet<Integer> getIntersection(ArrayList<Integer> a, ArrayList<Integer> b){


    

    HashSet <Integer> ah = new HashSet<>(a);
    HashSet <Integer> bh = new HashSet<>(b);


    // ArrayList<Integer> res = new ArrayList<>();

    // if(ah.size() <= bh.size()){
    //   for(Integer var : ah){
    //     if(bh.contains(var)){
    //       res.add(var);
    //     }
    //   }
    // }
    // else{
    //   for(Integer var : bh){
    //     if(ah.contains(var)){
    //       res.add(var);
    //     }
    //   }
    // }
    

    ah.retainAll(bh);
    return ah;
  } 


  public static void main(String[] args) {


    ArrayList <Integer> a  = new ArrayList<>(Arrays.asList(1, 2,2,4, 5));
    ArrayList <Integer> b  = new ArrayList<>(Arrays.asList(5, 6,6, 4,1));
    
    
    System.out.println(getIntersection(a, b));

  }
}
