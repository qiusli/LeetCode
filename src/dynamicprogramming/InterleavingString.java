package dynamicprogramming;

/**
 * Created by liqiushi on 8/25/14.
 * http://blog.csdn.net/u011095253/article/details/9248073
 */
public class InterleavingString {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;

        if (s1.length() + s2.length() != s3.length())
            return false;

        // dp[i][j]表示s1中使用i个,s2中使用j个元素
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        // s3不使用s2中的元素,且连续使用s1中的元素
        for (int i = 1; i < s1.length() + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
                dp[i][0] = true;
        }

        // s3不使用s1中的元素,且连续使用s2中的元素
        for (int i = 1; i < s2.length() + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1])
                dp[0][i] = true;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                    dp[i][j] = true;

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])
                    dp[i][j] = true;
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // time limit exceeded
    private static boolean recursion(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p3 == s3.length())
            return true;

        // s1 all used
        if (p1 == s1.length())
            return s2.substring(p2).equals(s3.substring(p3));

        // s2 all used
        if (p2 == s2.length())
            return s1.substring(p1).equals(s3.substring(p3));

        if (s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3))
            return recursion(s1, s2, s3, p1 + 1, p2, p3 + 1) || recursion(s1, s2, s3, p1, p2 + 1, p3 + 1);
        else if (s1.charAt(p1) == s3.charAt(p3))
            return recursion(s1, s2, s3, p1 + 1, p2, p3 + 1);
        else if (s2.charAt(p2) == s3.charAt(p3))
            return recursion(s1, s2, s3, p1, p2 + 1, p3 + 1);
        else
            return false;
    }
}
