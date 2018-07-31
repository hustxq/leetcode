package leetcode.array;

/**
 * Created by qxiong on 2018/4/24 0024.
 */
public class PlusOne66 {
    public static void main(String[] args) {
        int[] ds = {9, 9, 8};
        int[] res = plusOne(ds);
        for (int i : res) {
            System.out.print(i);
        }
    }

    static public int[] plusOne(int[] digits) {
        int jw = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + jw == 10) {
                digits[i] = 0;
                jw = 1;
            }else {
                digits[i] += 1;
                jw = 0;
                break;
            }
        }
        int[] res;
        if (jw == 1) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
        } else {
            res = digits;
        }
        return res;
    }
}
