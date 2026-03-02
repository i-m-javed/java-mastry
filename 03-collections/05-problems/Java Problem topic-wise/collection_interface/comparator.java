package collection_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Define a Car class
class Car {
  public String brand;
  public String model;
  public int year;
  
  public Car(String b, String m, int y) {
    this.brand = b;
    this.model = m;
    this.year = y;
  }
}



public class comparator { 
  public static void main(String[] args) { 
    ArrayList<Car> myCars = new ArrayList<Car>();    
    myCars.add(new Car("BMW", "X5", 1999));
    myCars.add(new Car("Honda", "Accord", 2006));
    myCars.add(new Car("Ford", "Mustang", 1970));

    Collections.sort(myCars, new Comparator<Car>() {
      public int compare(Car a, Car b) {
        if(a.year == b.year) {
          return 0;
        } else if (a.year > b.year) {
          return 1;
        } else {
          return -1;
        }
      }
    });

    for (Car c : myCars) {
      System.out.println(c.brand + " " + c.model + " " + c.year);
    }
  } 
}
