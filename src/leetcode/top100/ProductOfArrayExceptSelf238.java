package leetcode.top100;

/**
 * Created by qxiong on 2018/3/14 0014.
 */
public class ProductOfArrayExceptSelf238 {

    static public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }

    static public int[] productExceptSelf(int[] nums) {
        int res = 1;
        int[] vals = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            res *= nums[i];
        }
        vals[0] = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) vals[i] = 0;
            else {
                vals[i] = res / nums[i] * vals[0];
            }
        }
        return vals;
    }

    //        利用位操作 实现除法
    static private int divide(int a, int b) {
        Integer ai = a;
//        ai.toBinaryString()
        return a;
    }

    public static void main(String[] args) {

        int[] nums = {5, 9, 2, -9, -9, -7, -8, 7, -9, 10};
        int[] vals = productExceptSelf(nums);
        for (int i : vals) {
            System.out.print(i + " ");
        }

    }
}
