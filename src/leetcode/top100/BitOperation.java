package leetcode.top100;

/**
 * Created by qxiong on 2018/3/14 0014.
 */
public class BitOperation {

    public static void main(String[] args) {
//        1.~n = -(n+1)
//        System.out.println(~3); -4
//        2.获取整数n的二进制串中最后一个1 -n&n
        int i = 12;
//        System.out.println(Integer.toBinaryString(i)); 1100
//        System.out.println(-i&i); 4
//        3.去掉整数n的二进制串中最后一个1 n & (n-1)
//        System.out.println(i & (i - 1));

        System.out.println(divide(-25, -4));
        System.out.println(-25 / -4);
    }

    public static int add(int a, int b) {
        int res = a;
        int xor = a ^ b;
        int forward = (a & b) << 1;
        if (forward != 0) {
            res = add(xor, forward);
        } else {
            res = xor;
        }
        return res;
    }

    public static int minus(int a, int b) {
//        -b = ~(b-1)
        return add(a, ~(b - 1));
    }

    public static int multi(int a, int b) {
        int sign = 1;
        if (a < 0) {
            sign = -sign;
            a = -a;
        }
        if (b < 0) {
            sign = -sign;
            b = -b;
        }
        int i = 0;
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res += a << i;
            }
            b >>= 1;
            i++;
        }
        if (sign < 0) return -res;
        return res;
    }

    public static int divide(int a, int b) {
        int sign = 1;
        if (a < 0) {
            sign = -sign;
            a = -a;
        }
        if (b < 0) {
            sign = -sign;
            b = -b;
        }
        if (sign < 0) return -divide2(a, b);
        return divide2(a, b);
    }

    private static int divide2(int a, int b) {
        System.out.println(a+","+b);
        if (a<=0 || a < b) return 0;
        return divide2((a-b), b) + 1;
    }
}
