package leetcode.array;

public class MatrixScore861 {

    static public int matrixScore(int[][] A) {
        int r = A.length, c = A[0].length;
        int res = r * (1 << (c - 1));

        for (int i = 1; i < c; i++) {
            int one = 0;
            for (int j = 0; j < r; j++) {
                if (A[j][0] == 1) {
                    one += A[j][i];
                } else {
                    one += (1 - A[j][i]);
                }
            }
            int m = Math.max(one, r - one);
            res += m * (1 << (c - i - 1));
        }
        return res;
    }
}
