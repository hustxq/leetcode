package leetcode.top100;

/**
 * Created by qxiong on 2018/1/18 0018.
 */
public class RemoveElement27 {
    static public int removeElement(int[] nums, int val) {
        int c = 0;
        for (int i = 0,len = nums.length; i < len; i++) {
            if (nums[i]==val){
                c++;
            }
        }
        return c;
    }
}
