package leetcode.top100;

/**
 * Created by qxiong on 2018/1/24 0024.
 */
public class SortColors75 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        sortColors(nums);
    }

    static public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
//        0 1 2
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (nums[l] == 0 && l < r) {
                l++;
            }
            while (nums[r] != 0 && l < r) {
                r--;
            }

//            swap
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                /*System.out.println(l + "," + r);
                for (int i : nums) {
                    System.out.print(i + "\t");
                }
                System.out.println();*/
            }

        }
        r = nums.length - 1;
        while (l < r) {
            while (nums[l] == 1 && l < r) {
                l++;
            }
            while (nums[r] != 1 && l < r) {
                r--;
            }

//            swap
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;

                /*System.out.println(l + "," + r);
                for (int i : nums) {
                    System.out.print(i + "\t");
                }
                System.out.println();*/
            }
        }
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }

}
