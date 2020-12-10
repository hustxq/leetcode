package intv;

public class Massage1716 {

    static public int massage(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = nums[1];
        f[2] = nums[2] + f[0];
        for (int i = 3; i < n; i++) {
            f[i] = Math.max(f[i - 2], f[i - 3]) + nums[i];
        }
        return Math.max(f[n - 2], f[n - 1]);
    }
}
