package leetcode.top100;

/**
 * Created by qxiong on 2018/1/23 0023.
 */
public class UniquePathsII63 {
    public static void main(String[] args) {
        int[][] obs = new int[][]{
                {1,0,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obs));
    }

    static public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return -1;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] val = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (int j = i; j < m; j++) {
                    val[i][0] = 0;
                }
                break;
            } else {
                val[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                for (int j = i; j < n; j++) {
                    val[0][i] = 0;
                }
                break;
            } else {
                val[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    val[i][j] = val[i - 1][j] + val[i][j - 1];
                else val[i][j] = 0;
            }
        }
        return val[m - 1][n - 1];
    }
}
