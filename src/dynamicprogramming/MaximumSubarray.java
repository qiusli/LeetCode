package dynamicprogramming;

/**
 * Created by liqiushi on 8/22/14.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(A));
        System.out.println(maxSubArray2(A));
    }

    //如果前一个值拖当前值的后腿(即当前值和前一个值的和小于当前值),就舍弃前一个值
    //这样下来dp中的每一个元素都是前面到当前的最大累计值
    private static int maxSubArray(int[] A) {
        if (A == null)
            return 0;

        int[] dp = new int[A.length];
        int max = dp[0];
        dp[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] + dp[i - 1] >= A[i]) {
                dp[i] = dp[i - 1] + A[i];
            } else {
                dp[i] = A[i];
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    private static int maxSubArray2(int[] A) {
        if (A == null)
            return 0;

        return divide_conqure(A, 0, A.length - 1);
    }

    private static int divide_conqure(int[] a, int low, int high) {
        if (low == high)
            return a[low];

        int mid = (low + high) / 2;
        int left = divide_conqure(a, low, mid);
        int right = divide_conqure(a, mid + 1, high);

        if (left + right > left && left + right > right)
            return left + right;

        return Math.max(left, right);
    }
}
