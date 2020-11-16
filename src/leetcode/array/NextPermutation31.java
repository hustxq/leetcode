package leetcode.array;

public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5,1};
        for (int i = 0; i < 12; i++) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            nextPermutation(nums);
        }
    }

    static public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        boolean desc = true;

        int length = nums.length;

        for (int i = length - 1; i > 0; i--) {
            int tmp = nums[i - 1] - nums[i];
            if (tmp < 0) {
                desc = false;
                int j = i;
                for (; j < length; j++) {
                    if (nums[j] <= nums[i - 1]) {
                        break;
                    }
                }
                swap(nums, i - 1, j - 1);
                reverse(nums, i, length - 1);
                break;
            }
        }

        if (desc) {
            reverse(nums, 0, length - 1);
        }

    }

    private static void reverse(int[] nums, int s, int e) {
        int length = e - s + 1;
        for (int i = 0; i < length / 2; i++) {
            swap(nums, s + i, e - i);
        }
    }

    static private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
