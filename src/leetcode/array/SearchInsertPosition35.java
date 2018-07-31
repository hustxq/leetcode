package leetcode.array;

/**
 * Created by qxiong on 2018/3/28 0028.
 */
public class SearchInsertPosition35 {
    static public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int s = 0, e = nums.length - 1;
        if (target < nums[s]) return 0;
        if (target > nums[e]) return nums.length;
        int mid = 0;
        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return nums[s] < target ? s + 1 : s;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int t = 0;
        System.out.println(searchInsert(a, t));
    }
}
