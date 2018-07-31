package leetcode.top100;

/**
 * Created by qxiong on 2018/2/2 0002.
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }

    static public int singleNumber(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t ^= nums[i];
        }
        return t;
    }

    static private int tripleNumber(int[] nums){

        return 0;
    }
}
