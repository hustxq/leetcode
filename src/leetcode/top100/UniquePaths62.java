package leetcode.top100;

/**
 * Created by qxiong on 2018/1/23 0023.
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 1));
    }

    static public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return -1;
        int[][] val = new int[m][n];
        for (int i = 0; i < m; i++) {
            val[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            val[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                val[i][j] = val[i - 1][j] + val[i][j - 1];
            }
        }
        return val[m - 1][n - 1];
    }
}
