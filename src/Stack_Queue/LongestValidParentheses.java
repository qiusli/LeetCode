package Stack_Queue;

import java.util.Stack;

/**
 * Created by liqiushi on 7/21/14.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()()"));
        System.out.println(longestValidParentheses("())()"));
        System.out.println(longestValidParentheses(")))()"));
        System.out.println(longestValidParentheses("))))"));
        System.out.println(longestValidParentheses(")))(("));
        System.out.println(longestValidParentheses(")"));
        System.out.println(longestValidParentheses("(()("));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("(()()((()()()()"));
        System.out.println(longestValidParentheses("()(())")); // 6
    }

    private static int longestValidParentheses(String s) {
        if (s == null)
            return 0;

        if (s.trim().length() == 0)
            return 0;

        int max = 0, start = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // update start position when violation occurs (no matching '(' for ')')
                    start = i + 1;
                } else {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(i - start + 1, max) : Math.max(i - stack.peek(), max);
                }
            }
        }

        return max;
    }
}
