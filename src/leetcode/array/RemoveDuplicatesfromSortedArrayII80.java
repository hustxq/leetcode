package leetcode.array;

/**
 * Created by qxiong on 2018/5/18 0018.
 */
public class RemoveDuplicatesfromSortedArrayII80 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1(new int[]{1,1,1,1,2,2,2,3,3,3,4}));
    }
    static public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mark = nums[0]-1;
        int mark_count = 0;
        int cur = nums[0];
        int count = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (cur == nums[i]) {
                count++;
            } else {
                cur = nums[i];
                count = 1;
            }
            if (count > 2) {
                nums[i] = mark;
                mark_count++;
            }
        }
        /*for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();*/
        int offset = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == mark){
                offset++;
            }else {
                nums[i-offset] = nums[i];
            }
        }
        for (int i = len - mark_count; i < len; i++) {
            nums[i] = nums[i-1];
        }
        /*for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();*/
        return len - mark_count;
    }

    static public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0, count = 1;
        for (int i = 1,len = nums.length; i < len; i++) {
            if (nums[l] == nums[i]){
                count++;
            }else {
                if (count>2){
                    nums[l+count] = nums[i];
                    count=1;
                    l = l+count;
                }
            }
        }

        return 0;
    }
}
