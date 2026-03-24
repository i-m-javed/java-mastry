package others;

public class throwTest{
    public static void main(String...args){
        divide(10, 0);
        
    }

    public static  void divide(int a, int b){
        int res = 0;
        // try {
        //     res = a/b;
        //     System.out.println("result"+res);
        // }
        // catch(ArithmeticException e){
        //     System.out.println("Cannot divide by zero.");
        // }
        if(b == 0){
            throw new ArithmeticException("Negative divisor is not allowed.");
        }
        else{
            res = a/b;
            System.out.println("result"+res);
        }
    }
}