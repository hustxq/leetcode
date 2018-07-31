package leetcode.top100;

/**
 * Created by qxiong on 2018/1/17 0017.
 */
public class SearchForARange34 {
    public static void main(String[] args) {
        int[] res = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : res) {
            System.out.println(i);
        }
    }

    static public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <1) return nums;
        int s = 0, e = nums.length - 1, c = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                c = mid;
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        s = 0;
        e = nums.length - 1;
        int d = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                d = mid;
                s = mid + 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return new int[]{c, d};
    }
}
