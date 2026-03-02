package collection_interface;

import java.util.ArrayList;
import java.util.Collections;
class frequencyOFelement{
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);
    list.add(2);
    list.add(1);
    list.add(4);
    System.out.println("List: " + list);
    System.out.println("Frequency of 1: " + Collections.frequency(list, 1));
    System.out.println("Frequency of 2: " + Collections.frequency(list, 2));
    System.out.println("Frequency of 3: " + Collections.frequency(list, 3));
    System.out.println("Frequency of 4: " + Collections.frequency(list, 4));
    System.out.println("Frequency of 5: " + Collections.frequency(list, 5));
  }
}