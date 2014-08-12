package dynamicprogramming;

/**
 * Created by liqiushi on 8/10/14.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid2 = {{1, 0}};
        int[][] obstacleGrid3 = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
        System.out.println(uniquePathsWithObstacles(obstacleGrid3));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1)
            return 0;

        int[][] tmp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0)
                tmp[i][0] = 1;
            else
                break;
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0)
                tmp[0][i] = 1;
            else
                break;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    tmp[i][j] = 0;
                else
                    tmp[i][j] = tmp[i - 1][j] + tmp[i][j - 1];
            }
        }

        return tmp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
