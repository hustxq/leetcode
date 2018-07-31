package leetcode.array;

/**
 * Created by qxiong on 2018/3/29 0029.
 */
public class MinimumPathSum {
    static public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] vals = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            vals[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            vals[0][i] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                vals[i][j] = Math.min(vals[i - 1][j], vals[i][j - 1])+grid[i][j];
            }
        }
        return vals[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

}
