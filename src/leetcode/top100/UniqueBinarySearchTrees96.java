package leetcode.top100;

/**
 * Created by qxiong on 2018/1/29 0029.
 */
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
    static public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i < g.length; i++) {
            for (int j = 0; j < i; j++) {
                g[i] += g[j] * g[i - 1 - j];
            }
        }
        return g[n];
    }
}
