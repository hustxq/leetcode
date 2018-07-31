package algo;

/**
 * Created by sse on 2017/9/14.
 */
public class PowerofTwo {
    public static void main(String[] args) {
//         >> 除以2
//         << 乘以2
        // >>> 无符号右移 空位补零
//        System.out.println(-1>>>1);

        int target = 6;
        if (target <= 0) {
            System.out.println(target + "不是2的幂");
            return;
        } else if (target == 1) {
            System.out.println(target + "是2的幂");
            return;
        }
        int x = target;
        while (x > 1) {
            int t = x & 1;
            System.out.println(t);
            if (0 != t) {
                System.out.println(target + "不是2的幂");
                return;
            }
            x = x >> 1;
        }
        if (x==1){
            System.out.println(target + "是2的幂");
        }else {
            System.out.println(target + "不是2的幂");
        }
    }
}
