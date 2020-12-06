package intv;

public class MajorityElement1710 {

    static public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int m = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                m = num;
                count++;
            } else {
                if (m == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        if (count > 0) {
            int t = 0;
            for (int num : nums) {
                if (m == num) {
                    t++;
                }
            }
            if (t * 2 > nums.length) {
                return m;
            }
        }
        return -1;
    }
}
