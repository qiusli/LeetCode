package stackquene;

import java.util.Stack;

/**
 * Created by liqiushi on 7/20/14.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid(""));
        System.out.println(isValid("{]"));
        System.out.println(isValid("{]}"));
        System.out.println(isValid("}"));
    }

    private static boolean isValid(String s) {
        if (s == null)
            return false;

        if (s.length() == 0 || s.length() == 1)
            return false;

        if (s.trim().equals(""))
            return false;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0)
                    return false;

                char tmp = stack.pop();
                if (c == ')' && tmp != '(' || c == '}' && tmp != '{' || c == ']' && tmp != '[')
                    return false;
            }
        }

        return stack.size() == 0;
    }
}
