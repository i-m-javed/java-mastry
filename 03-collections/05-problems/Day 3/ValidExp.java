import java.util.*;

public class ValidExp {

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isOperator(char c) {
        return c == '*' || c == '-' || c == '+' || c == '/' || c == '%';
    }

    public static boolean validExp(String exp) {

        boolean lastWasOperator = true;

        for (char c : exp.toCharArray()) {

            if (isDigit(c)) {
                lastWasOperator = false;
            } else if (isOperator(c)) {
                if (lastWasOperator)
                    return false;
                else lastWasOperator = true;
            } else {
                return false;
            }
        }

        return !lastWasOperator;
    }

    public static void main(String[] args) {

        System.out.println(validExp("1+1/"));
        System.out.println(validExp("56*4/5"));
        System.out.println(validExp("234%"));

    }
}
