package leetcode.top100;

/**
 * Created by qxiong on 2018/1/16.
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    static public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 1) return;
        //
        boolean f = false;
        int l = 0, r = 0;
        int i = 1, len = nums.length;
        for (; i < len; i++) {
            if (nums[len - i] > nums[len - i - 1]) {
                l = len - 1 - i;
                System.out.println("l:"+l);
                f = true;
                break;
            }
        }
        if (!f) {
            for (int j = 0; j < (len - l) / 2; j++) {
                i = nums[l + j];
                nums[l + j] = nums[len - 1 - j];
                nums[len - 1 - j] = i;
            }
            return;
        }
        for (r = l + 1; r < len; r++) {
            if (nums[r] <= nums[l]) {
                break;
            }
        }
        r--;
        System.out.println("r:" + r);
//        swap l r
        i = nums[l];
        nums[l] = nums[r];
        nums[r] = i;

        l++;
//        reverse l+1;
        for (int j = 0; j < (len - l) / 2; j++) {
            i = nums[l + j];
            nums[l + j] = nums[len - 1 - j];
            nums[len - 1 - j] = i;
        }
    }
}
