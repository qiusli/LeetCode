package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 8/21/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcfabcdefg"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] table = new int[256];
        Arrays.fill(table, -1);

        int rear = 0, front = 1, max = 1;
        // char : index
        table[s.charAt(0)] = 0;
        while (front < s.length()) {
            char c = s.charAt(front);
            if (table[c] >= rear)
                rear = table[c] + 1;

            max = Math.max(max, front - rear + 1);
            table[c] = front;
            front++;
        }

        return max;
    }

    // time limit exceeded
    private static int lengthOfLongestSubstring_(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = new ArrayList<Character>();
            int curL = 0;
            int t = i;
            while (t < s.length() && !list.contains(s.charAt(t))) {
                list.add(s.charAt(t));
                curL++;
                t++;
            }

            if (curL > max)
                max = curL;
        }

        return max;
    }
}
