package leetcode.top100;

/**
 * Created by qxiong on 2018/1/19 0019.
 */
public class RotateImage48 {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(m);
    }

    static public void rotate(int[][] matrix) {
        int c = matrix.length / 2;
        int len = matrix.length;
        for (int i = 0; i < c; i++) {
            int x = 0 + i, y = len - 1 - i;
            for (int j = 0; j < len - 2 * i - 1; j++) {
                int a = matrix[x][len - 1 - y + j];
                int b = matrix[x + j][y];
                int m = matrix[len - 1 - x][y - j];
                int n = matrix[len - 1 - x - j][len - 1 - y];
                matrix[x + j][y] = a;
                matrix[len - 1 - x][y - j] = b;
                matrix[len - 1 - x - j][len - 1 - y] = m;
                matrix[x][len - 1 - y + j] = n;
                /*for (int[] k : matrix) {
                    for (int l : k) {
                        System.out.print(l + "\t");
                    }
                    System.out.println();
                }*/
            }

        }
        /*for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }*/
    }
}
