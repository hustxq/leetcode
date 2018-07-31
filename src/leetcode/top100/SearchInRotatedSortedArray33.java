package leetcode.top100;

/**
 * Created by qxiong on 2018/1/18 0018.
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        System.out.println(search2(new int[]{3, 5, 1}, 1));
    }

    /**
     * 先找出最大值
     *
     * @param nums
     * @param target
     * @return
     */
    static public int search2(int[] nums, int target) {
        int s = 0, e = nums.length - 1, max = 0;
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        } else if (nums.length == 2) {
            return target == nums[0] ? 0 : target == nums[1] ? 1 : -1;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (0 < mid && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    max = mid;
                    break;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    if (nums[s] < nums[mid]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    max = mid - 1;
                    break;
                }
            } else if (mid == 0) {
                max = 0;
                break;
            } else {
                max = nums.length - 1;
                break;
            }
        }
        System.out.println("max:" + max);
        s = 0;
//        e = nums.length - 1;
        if (nums[max] == target) return max;
        if (max == 0) {
            return binary(nums, 1, nums.length - 1, target);
        } else if (max == nums.length - 1) {
            return binary(nums, 0, nums.length - 2, target);
        } else {
            if (nums[s] == target) {
                return s;
            } else if (nums[s] < target) {
                return binary(nums, s + 1, max - 1, target);
            } else {
                return binary(nums, max + 1, nums.length - 1, target);
            }
        }
//        return max;
    }

    static private int binary(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    static public int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[s] == target) {
                    return s;
                } else if (nums[s] < nums[s]) {
                    e = mid - 1;
                } else {
                    s++;
                    e = mid - 1;
                }
            } else {
                if (nums[e] == target) {
                    return e;
                } else if (nums[e] > nums[mid]) {
                    s = mid + 1;
                    e--;
                } else {
                    s = mid + 1;
                    e--;
                }
            }
        }
        return -1;
    }
}
