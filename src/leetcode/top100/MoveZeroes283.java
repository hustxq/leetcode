package leetcode.top100;

/**
 * Created by qxiong on 2018/3/15 0015.
 */
public class MoveZeroes283 {

    static public void moveZeroes(int[] nums) {
        int n = nums.length;
//        int i=0,j=0;
        /*int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) c++;
        }*/
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    static public int removeElement(int[] nums, int val) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        break;
                    }
                }
            }
        }
        /*for (int i : nums) {
            System.out.print(i + " ");
        }*/
        int c = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == val) {
                c++;
            }
        }
        return n-c;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        moveZeroes(nums);
        int c = removeElement(nums, 0);
        System.out.println(c);
    }

}
