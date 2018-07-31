package leetcode.top100;

/**
 * Created by qxiong on 2018/1/15.
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4,8};
        System.out.println(maxSubArray(nums));
    }

    static public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = res;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (res < 0) {
                res = res < nums[i] ? nums[i] : res;
            } else {
                if (nums[i] < 0) {
                    sum = Math.max(sum, res);
                    if (res + nums[i] >= 0) {
                        res = res + nums[i];
                    }else {
                        res = 0;
                    }
                } else {
                    res += nums[i];
                }
            }
        }
        sum = Math.max(sum, res);
        return sum;
    }
}
