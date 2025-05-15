package AMAZONPROBLEMS;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                stack.push(str[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && str[i] != ')') || (top == '{' && str[i] != '}') || (top == '[' && str[i] != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()}";
        boolean result = isValid(s);
        System.out.println("The string is valid: " + result);

    }

}
