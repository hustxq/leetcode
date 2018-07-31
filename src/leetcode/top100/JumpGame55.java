package leetcode.top100;

/**
 * Created by qxiong on 2018/1/17 0017.
 */
public class JumpGame55 {
    public static void main(String[] args) {
        System.out.println(jumpII2(new int[]
                {2, 3, 1, 1, 4}
        ));
    }

    static public boolean canJump2(int[] nums) {
        int target = nums.length - 1;
        int l = target;
        for (int i = l; i >= 0; i--) {
            if (i + nums[i] >= target) target = i;
        }
        return target <= 0;
    }

    static public int jumpII2(int[] nums) {
        int target = nums.length - 1;
        int[] vals = new int[nums.length];
        vals[target] = 1;
        int cur = target;
        for (int i = target - 1; i >= 0; i--) {
            if (nums[i] == 0) continue;
            if (i + nums[i] >= target && vals[target] > 0) {
                vals[i] = vals[target] + 1;
                cur = i;
            }
            if (i + nums[i] < target) {
                /*target = cur;
                vals[i] = vals[target]+1;*/
                int min = vals[i + 1];
                for (int j = i + 2; j <= i + nums[i]; j++) {
                    if (min==0){
                        min = vals[j];
                    }
                    if (vals[j]>0 && min > vals[j]) {
                        min = vals[j];
                    }
                }
                vals[i] = min + 1;
            }
        }
        /*for (int i = 0; i < vals.length; i++) {
            System.out.print(vals[i] + "\t");
        }*/
        return vals[0]-1;
    }

    static public int jumpII3(int[] nums) {
        int target = nums.length - 1;
        int p = nums[0];
        int count = 1;
        for (int i = 1; i < target; i++) {
            if (i + nums[i] > p) {

            }
        }
        return 0;
    }

    /**
     * time limited
     *
     * @param nums
     * @return
     */
    static public int jumpII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        int len = nums.length;
        int target = len - 1;
        int[] iarr = new int[len];
        iarr[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (iarr[i] > 0) {
                    if (i + j <= target) {
                        if (iarr[i + j] == 0) {
                            iarr[i + j] = iarr[i] + 1;
                        } else {
                            iarr[i + j] = Math.min(iarr[i + j], iarr[i] + 1);
                        }
                    }
                    if (i + j == target) return iarr[target] - 1;
                }
            }
        }
        /*for (int i : iarr) {
            System.out.print((i - 1) + "\t");
        }*/
        return iarr[target] - 1;
    }

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    static public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        int len = nums.length;
        int target = len - 1;
        int[] iarr = new int[target + 1];
        iarr[0] = 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (iarr[i] == 1) {
                    if (i + j == target) {
                        return true;
                    } else if (i + j < target) {
                        iarr[i + j] = 1;
                    }
                }
            }
        }
        /*for (int i = len - 1; i >= 0; i--) {

        }*/
        return iarr[target] == 1;
    }
}
