package leetcode.top100;

/**
 * Created by qxiong on 2018/3/2 0002.
 */
public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1};
        System.out.println(rob(nums));
    }
    static public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);

        int[] vals = new int[nums.length];

        vals[0] = nums[0];
        vals[1] = Math.max(nums[0], nums[1]);
        vals[2] = Math.max(nums[0]+nums[2], nums[1]);

        for (int i = 3; i < nums.length; i++) {
            vals[i] = Math.max(vals[i-2],vals[i-3])+nums[i];
        }

        for(int i:vals){
            System.out.print(i+" ");
        }

        int len = vals.length;
        if (vals[len-1]>vals[len-2]){
            return vals[len-1];
        }
        return vals[len-2];
    }

}
