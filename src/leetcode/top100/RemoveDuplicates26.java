package leetcode.top100;

/**
 * Created by qxiong on 2018/3/15 0015.
 */
public class RemoveDuplicates26 {

    static public int removeDuplicates(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int j = i + 2;
                for (; j < n; j++) {
                    if (nums[j] != nums[i]) {
                        for (int k = i + 1; k < j; k++) {
                            nums[k] = nums[j];
                        }
                        break;
                    }
                }
            }
        }
        /*for (int i : nums) {
            System.out.print(i + " ");
        }*/
        int c = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                c++;
            }
        }
        return n - c;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
