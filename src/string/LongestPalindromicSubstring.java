package string;

/**
 * Created by liqiushi on 7/13/14.
 * http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 * http://www.felix021.com/blog/read.php?2040
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        String s = "xyzabcdedcbamqp";
        String s = "xyzabcdedcbamqpabcbafps";
        System.out.print(my_longestPalindrome("aaaaaaaaaaa"));
    }

    // exceeds time limits
    private static String my_longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.equals(""))
            return s;

        char[] t = new char[s.length() * 2 + 1];
        int j = 0;
        for (int i = 0; i < t.length - 1; i += 2) {
            t[i] = '#';
            t[i + 1] = s.charAt(j++);
        }
        t[s.length() * 2] = '#';

        int center = 0, right_edge = 0;
        int[] p = new int[s.length() * 2 + 1];
        for (int i = 1; i < t.length - 1; i++) {
            int p_mirror = center - (i - center);
            p[i] = right_edge > i ? Math.min(p[p_mirror], right_edge - i) : 1;

            while (i - p[i] >= 0 && i + p[i] < t.length &&
                    t[i - p[i]] == t[i + p[i]])
                p[i]++;

            if (i + p[i] > right_edge) {
                right_edge = i + p[i];
                center = i;
            }
        }

        int max_len = Integer.MIN_VALUE, max_idx = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > max_len) {
                max_len = p[i];
                max_idx = i;
            }
        }

        int beginIndex = (max_idx + 1 - max_len) / 2;
        int endIndex = beginIndex + max_len - 1;
        return s.substring(beginIndex, endIndex);
    }
}
