package leetcode.top100;

import java.util.Arrays;

/**
 * Created by qxiong on 2018/3/7 0007.
 */
public class KthLargestElementinanArray215 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 4;
        System.out.println(findKthLargest(nums,k));
    }

    static public int findKthLargest(int[] nums, int k) {
        int[] vals = new int[k];

        for (int i = 0; i < k; i++) {
            vals[i] = nums[i];
        }

        Arrays.sort(vals);

        for (int i:vals){
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i = k, len = nums.length; i < len; i++) {
            if (vals[0] < nums[i] && nums[i] <= vals[k - 1]) {
                for (int j = 0; j < k; j++) {
                    if (vals[j] >= nums[i]) {
                        for (int l = 0; l < j-1; l++) {
                            vals[l] = vals[l+1];
                        }
                        vals[j-1] = nums[i];
                        break;
                    }
                }
            }
            if (vals[k-1] < nums[i]){
                for (int l = 0; l < k-1; l++) {
                    vals[l] = vals[l+1];
                }
                vals[k-1] = nums[i];
            }
            for (int m:vals){
                System.out.print(m+" ");
            }
            System.out.println();
        }
        return vals[0];
    }
}
