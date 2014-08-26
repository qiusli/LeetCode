package dynamicprogramming;

/**
 * Created by liqiushi on 8/25/14.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        if (grid == null)
            return -1;

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = grid[i][j];

                int up = i - 1 >= 0 ? dp[i - 1][j] : -1;
                int left = j - 1 >= 0 ? dp[i][j - 1] : -1;

                if (up == -1) {
                    if (left != -1) {
                        dp[i][j] += left;
                    }
                } else {
                    if (left == -1) {
                        dp[i][j] += up;
                    } else {
                        dp[i][j] += Math.min(up, left);
                    }
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
