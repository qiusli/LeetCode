package array;

import java.util.HashSet;

/**
 * Created by liqiushi on 6/27/14.
 */
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(num));
    }

    public static int longestConsecutive(int[] num) {
        if (num == null)
            return -1;

        if (num.length == 1)
            return 1;

        HashSet<Integer> used = new HashSet<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : num)
            set.add(n);

        int longest = 0;

        for (int n : num) {
            int curLongest = 1;

            int tmp = n - 1;
            while (!used.contains(tmp) && set.contains(tmp)) {
                used.add(tmp);
                curLongest++;

                tmp--;
            }

            tmp = n + 1;

            while (!used.contains(tmp) && set.contains(tmp)) {
                used.add(tmp);
                curLongest++;

                tmp++;
            }

            longest = longest > curLongest ? longest : curLongest;
        }

        return longest;
    }
}
