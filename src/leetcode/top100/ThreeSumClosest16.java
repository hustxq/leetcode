package leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/10.
 */
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

    static public int threeSumClosest(int[] nums, int target) {
//        List<List<Integer>> res = new LinkedList<>();
        int offset = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
//            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
            {
                int l = i + 1, r = len - 1, sum = target - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
//                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        return target;
                        /*while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;*/
                    } else if (nums[l] + nums[r] < sum) {
                        if (Math.abs(offset) > Math.abs(sum - nums[l] - nums[r])) {
                            offset = (sum - nums[l] - nums[r]);
                        }
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        if (Math.abs(offset) > Math.abs(sum - nums[l] - nums[r])) {
                            offset = (sum - nums[l] - nums[r]);
                        }
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
//        System.out.println(offset);
        return target - offset;
    }
}
