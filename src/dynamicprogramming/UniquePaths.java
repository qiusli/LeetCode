package dynamicprogramming;

/**
 * Created by liqiushi on 8/9/14.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(10, 1));
    }

    private static int uniquePaths(int m, int n) {
        int[][] k = new int[m][n];

        for (int i = 0; i < m; i++)
            k[i][0] = 1;
        for (int i = 0; i < n; i++)
            k[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                k[i][j] = k[i - 1][j] + k[i][j - 1];
            }
        }

        return k[m - 1][n - 1];
    }
}
