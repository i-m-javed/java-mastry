import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

    public static boolean isBalanced(String pth) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < pth.length(); i++) {
            char c = pth.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if ((c == ']' && !stack.isEmpty() && stack.pop() == '[') ||
                       (c == '}' && !stack.isEmpty() && stack.pop() == '{') ||
                       (c == ')' && !stack.isEmpty() && stack.pop() == '(')) {
                continue;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the parenthesis expression: ");
        String pth = scanner.next();
        if (isBalanced(pth)) {
            System.out.println("\nBalanced");
        } else {
            System.out.println("\nNot balanced");
        }
        scanner.close();
    }
}