package string;

/**
 * Created by liqiushi on 7/20/14.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("hello ld"));
        System.out.println(lengthOfLastWord("abc"));
        System.out.println(lengthOfLastWord("ab c"));
        System.out.println(lengthOfLastWord("ab "));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord("      "));
    }

    private static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;

        if (s.trim().length() == 0)
            return 0;

        s = s.trim();
        int len = s.length();
        int rear_ptr = len - 1;
        while (rear_ptr >= 0 && s.charAt(rear_ptr) != ' ')
            rear_ptr--;

        return len - rear_ptr - 1;
    }
}
