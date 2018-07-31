package leetcode.array;

/**
 * Created by qxiong on 2018/3/28 0028.
 */
public class RotateArray189 {
    static public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static private void reverse(int[] nums, int s, int e) {
        int c = (e - s + 1) / 2;
        for (int i = 0; i < c; i++) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
        /*for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();*/
    }

    public static void main(String[] args) {
        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate(iarr, 3);
    }
}
