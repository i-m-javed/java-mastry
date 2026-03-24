import java.util.Stack;

public class DuplicateStack {

    public static void duplicate(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

        int top = stack.pop();

        duplicate(stack);

        stack.push(top);
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        duplicate(stack);

        System.out.println(stack);
    }
}