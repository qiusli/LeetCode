package dynamicprogramming;

/**
 * Created by liqiushi on 8/22/14.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("leetcode"));
        System.out.println(minCut("leet"));
        System.out.println(minCut("aaaa"));
        System.out.println(minCut("aabaa"));
        System.out.println(minCut("aabbcaa"));
        System.out.println(minCut("cbbbcc"));
    }

    private static int minCut(String s) {
        if (s == null)
            return 0;

        boolean[][] palin = new boolean[s.length()][s.length()];
        // construct the look-up table for palindrome
        // palin[i][j] means string from i to j (inclusive) is palindrome
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || palin[i + 1][j - 1])) {
                    palin[i][j] = true;
                } else {
                    palin[i][j] = false;
                }
            }
        }

        // if input is "leet" and the rear is 2nd and front is the last,
        // then the process here will be check "eet", "et" and "t" to find smallest
        // cutting number
        int[] cut = new int[s.length()];
        for (int front = 0; front < s.length(); front++) {
            cut[front] = s.length();
            if (palin[0][front])
                cut[front] = 0;
            else
                for (int rear = 0; rear < front; rear++)
                    if (palin[rear + 1][front] && cut[rear] + 1 < cut[front])
                        cut[front] = cut[rear] + 1;
        }

        return cut[s.length() - 1];
    }
}
