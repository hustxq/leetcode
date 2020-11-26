package leetcode.array;

import java.util.Arrays;

public class MaximumGap164 {

    static public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int maxDiff = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxDiff = Math.max(maxDiff, nums[i + 1] - nums[i]);
        }

        return maxDiff;
    }

    static private void radixSort(int[] nums) {
        int n = nums.length;
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 1};
        radixSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
