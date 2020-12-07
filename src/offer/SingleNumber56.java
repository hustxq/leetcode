package offer;

public class SingleNumber56 {

    public static void main(String[] args) {
        int[] arr = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(arr));
    }

    static public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }
}
