package string;

import java.util.Stack;

/**
 * Created by liqiushi on 7/12/14.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "";
        System.out.print(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        if (s == null)
            return false;

        if (s.equals(""))
            return true;

        int front = 0, rear = s.length() - 1;
        while (front < rear) {
            while (!Character.isLetter(s.charAt(front))) {
                front++;
                if (front > s.length() - 1) {
                    return true;
                }
            }

            while (!Character.isLetter(s.charAt(rear))) {
                rear--;
                if (rear < 0) {
                    return true;
                }
            }

            if (String.valueOf(s.charAt(front)).equalsIgnoreCase(String.valueOf(s.charAt(rear)))) {
                front++;
                rear--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int len = s.length();
        if (len < 2)
            return true;

        Stack<Character> stack = new Stack<Character>();

        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }

        if (len % 2 == 1)
            index++;

        while (index < len) {
            if (stack.empty())
                return false;

            char temp = stack.pop();
            if (s.charAt(index) != temp)
                return false;
            else
                index++;
        }

        return true;
    }
}
