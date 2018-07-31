package leetcode.top100;

import java.util.Arrays;

/**
 * Created by qxiong on 2018/3/20 0020.
 */
public class SlidingWindowMaximum239 {
    static public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[]{};
        int n = nums.length;
        int len = n - k + 1;
        int[] vals = new int[len];
        int i = 0;
        int max = nums[0];
        int mp = -1;
        for (int j = 0; j < k; j++) {
            if (max < nums[j]) {
                max = nums[j];
                mp = j;
            }
        }
        int p = 0;
//        System.out.println(max+":max");
        vals[p++] = max;

        while (i < len - 1) {
//            最大值不在当前窗口内，重新找出最大值及下标
            if (mp < i + 1) {
                max = nums[i + 1];
                mp = i + 1;
                for (int j = 0; j < k; j++) {
                    if (max < nums[i + j + 1]) {
                        max = nums[i + j + 1];
                        mp = i + j + 1;
                    }
                }
            } else /*最大值在窗口内*/ {
                if (nums[i + k] > max) {
                    max = nums[i + k];
                    mp = i + k;
                }
            }
//            System.out.println(max+":max");
            vals[p++] = max;

            i++;
        }
        return vals;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] vals = maxSlidingWindow(nums, k);
        for (int i : vals) {
            System.out.print(i + " ");
        }
    }
}
