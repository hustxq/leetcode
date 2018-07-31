package leetcode.array;

/**
 * Created by qxiong on 2018/7/31 0031.
 */
public class MergeSortedArray88 {
    static public void merge2(int[] nums1, int m, int[] nums2, int n){

    }
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = 0, j = 0;
        while (i < m) { // && j < n
            if (nums1[i] > nums2[j]) {
                int t = nums1[i];
                nums1[i] = nums2[j];
//                nums2[j] = t;
//                System.out.println(t);
//                resort num2
                if (n == 1) {
                    nums2[j] = t;
                    continue;
                }
                for (int k = 1; k < n; k++) {
//                    System.out.println(nums2[k]);
                    if (t <= nums2[k]) {
                        nums2[k - 1] = t;
                        break;
                    } else {
                        nums2[k - 1] = nums2[k];
                        if (k == n - 1) {
                            nums2[k] = t;
                        }
                    }
                }
            }
            i++;

        }

        int len = m + n;
        for (; i < len; i++) {
            nums1[i] = nums2[j++];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + "\t");
        }
    }
}
