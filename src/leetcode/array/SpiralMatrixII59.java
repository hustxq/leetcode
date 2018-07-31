package leetcode.array;

/**
 * Created by qxiong on 2018/5/21 0021.
 */
public class SpiralMatrixII59 {

    public static void main(String[] args) {
        int[][] vals = generateMatrix(6);
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[0].length; j++) {
                System.out.print(vals[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public int[][] generateMatrix(int n) {
        if (n < 1) return null;
        if (n == 1) return new int[][]{{1}};
        int max = n * n;
        int[][] vals = new int[n][n];
        vals[0][0] = 1;
        int x = 0, y = 0;
        int v = 2;
        int dir = 0;
        int rn = 1, cn = 0, cm = n - 1, rm = n - 1;
        while (v <= max) {
            if (dir == 0) {
                if (y == cm) {
                    dir = 1;
                    cm--;
                } else
                    y++;
            }
            if (dir == 1) {
                if (x == rm) {
                    dir = 2;
                    rm--;
                } else
                    x++;
            }
            if (dir == 2) {
                if (y == cn) {
                    dir = 3;
                    cn++;
                } else
                    y--;
            }
            if (dir == 3) {
                if (x == rn) {
                    dir = 0;
                    rn++;
                    vals[x][++y] = v++;
                    continue;
                } else
                    x--;
            }
            vals[x][y] = v;
            v++;
            /*System.out.println();
            for (int i = 0; i < vals.length; i++) {
                for (int j = 0; j < vals[0].length; j++) {
                    System.out.print(vals[i][j] + " ");
                }
                System.out.println();
            }*/
        }
        return vals;
    }
}
