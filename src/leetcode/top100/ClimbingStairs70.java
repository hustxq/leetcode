package leetcode.top100;

/**
 * Created by qxiong on 2018/1/15.
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(4));
    }

    /**
     * 递归方式
     *
     * @param n
     * @return
     */
    static public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 中间数组
     *
     * @param n
     * @return
     */
    static public int climbStairs2(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] iarr = new int[n + 1];
        iarr[1] = 1;
        iarr[2] = 2;
        int p = 3;
        while (n >= p) {
            iarr[p] = iarr[p - 1] + iarr[p - 2];
            p++;
        }
        return iarr[n];
    }

}
