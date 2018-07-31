package leetcode.top100;

/**
 * Created by qxiong on 2018/3/23 0023.
 */
public class LongestIncreasingSubsequence300 {

    static public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int n = nums.length;
        int[] vals = new int[n];
        vals[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    vals[i] = Math.max(vals[j], vals[i]);
                }
            }
            vals[i] += 1;
            System.out.print(" " + vals[i]);
            if (len < vals[i]) {
                len = vals[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
//                {1, 3, 6, 7, 9, 4, 10, 5, 6};
//                {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("\n" + lengthOfLIS(ints));
    }
}
