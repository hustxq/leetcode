package leetcode.array;

public class SearchRange34 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(nums, 18);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{
                -1, -1
        };
        if (nums == null || nums.length == 0) {
            return res;
        }

        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                e = mid - 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        s = 0;
        e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s + 1) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }
}
