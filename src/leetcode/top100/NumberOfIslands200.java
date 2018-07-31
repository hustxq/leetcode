package leetcode.top100;

/**
 * Created by qxiong on 2018/3/5 0005.
 */
public class NumberOfIslands200 {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return count;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsMarking(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMarking(grid, i - 1, j);
        dfsMarking(grid, i, j + 1);
        dfsMarking(grid, i + 1, j);
        dfsMarking(grid, i, j - 1);
    }
}
