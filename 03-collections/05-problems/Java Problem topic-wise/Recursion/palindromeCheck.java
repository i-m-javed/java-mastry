package Recursion;

import java.util.*;

public class palindromeCheck{

    public static boolean palindrome(int i, String str) {
    int n = str.length();
    if (i >= n / 2)
    return true;
        
    if(str.charAt(i) != str.charAt(n-1-i)) return false;
    
    return palindrome(i+1, str);

    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println(palindrome(0, "ajkas"));
        sc.close();
    }
    
}

