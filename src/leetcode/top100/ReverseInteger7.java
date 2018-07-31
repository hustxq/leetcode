package leetcode.top100;

import java.math.BigInteger;

/**
 * Created by qxiong on 2018/1/11.
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(reverse2(Integer.MAX_VALUE));//Integer.MAX_VALUE / 10 //123
    }

    static public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int nr = res * 10 + t;
            if ((nr - t) / 10 != res) return 0;
            res = nr;
            x /= 10;
        }
        return res;
    }

    /**
     * 字符串的反转，再转换为int，有边界错误，需要额外判断
     *
     * @param x
     * @return
     */
    static public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        String s = x + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            sb.append(s.charAt(len - 1 - i));
        }
        return new BigInteger(sb.toString()).multiply(new BigInteger(sign + "")).intValue();
    }
}
