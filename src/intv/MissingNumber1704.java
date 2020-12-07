package intv;

public class MissingNumber1704 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 2, 1}));
    }

    static public int missingNumber(int[] nums) {
        int n = nums.length;
        int nSum = (n * (n + 1)) >> 1;
        for (int num : nums) {
            nSum -= num;
        }
        return nSum;
    }
}
