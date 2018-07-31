package leetcode.top100;

/**
 * Created by qxiong on 2018/3/1 0001.
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,2};
        System.out.println(majorityElement(nums));
    }
    static public int majorityElement(int[] nums) {
        /*if (nums.length <= 2) {
            return nums[0];
        }*/
        int c = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (pre == nums[i]) {
                c++;
            } else {
                c--;
                if (c == 0) {
                    pre = nums[i + 1];
                }
            }
        }
        if (c >= 1) return pre;
        return nums[nums.length-1];
    }
}
