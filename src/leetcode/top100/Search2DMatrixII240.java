package leetcode.top100;

/**
 * Created by qxiong on 2018/3/21 0021.
 */
public class Search2DMatrixII240 {

    static public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int m = matrix.length - 1;
        int n = matrix[0].length;
        int i = 0;
        while (0 <= m && i < n) {
            if (matrix[m][i] == target) {
                return true;
            } else if (matrix[m][i] > target) {
                m--;
            } else {
                i++;
            }
        }
        return false;
    }

    static public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        return false;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };/*{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/
        System.out.println(searchMatrix(m, 20));
    }
}
