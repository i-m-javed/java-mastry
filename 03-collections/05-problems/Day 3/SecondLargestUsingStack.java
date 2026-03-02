import java.util.Stack;

public class SecondLargestUsingStack {

    public static int findSecondLargest(Stack<Integer> stack) {

        if (stack.size() < 2) {
            throw new RuntimeException("Not enough elements");
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int value = stack.pop();

            if (value > largest) {
                second = largest;
                largest = value;
            } else if (value > second && value != largest) {
                second = value;
            }

            temp.push(value);
        }

        // Restore original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return second;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Second Largest: " + findSecondLargest(stack));
    }
}