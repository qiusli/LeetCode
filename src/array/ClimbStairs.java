package array;

/**
 * Created by liqiushi on 7/4/14.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.print(climbStairs(3));
    }

    private static int climbStairs(int n) {
        if (n < 2)
            return 1;

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++) {
            if (i - 2 >= 0)
                ways[i] += ways[i - 2];
            if (i - 1 >= 0)
                ways[i] += ways[i - 1];
        }

        return ways[n - 1];
    }
}
