package Recursion;

public class printNtimes {
  public static int count = 0;
  public static void print(int n){
    if(count == 5){
        return;
    }
    System.out.println(n);
    count++;
    print(n);
  }

    
    public static void main(String[] args) {
		print(12);
	}
}




