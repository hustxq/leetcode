package leetcode.array;

/**
 * Created by qxiong on 2018/4/24 0024.
 */
public class MinPathSum64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    static public int minPathSum(int[][] grid) {
        int[][] vals = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            vals[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            vals[0][i] = sum;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                vals[i][j] = Math.min(vals[i - 1][j], vals[i][j - 1]) + grid[i][j];
            }
        }
        return vals[grid.length-1][grid[0].length-1];
    }
}
