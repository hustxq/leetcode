package algo;

/**
 * Created by sse on 2017/9/14.
 */
public class MissingNumber {
    /*
    * 方法一
    * 对给定数组进行排序，然后依次扫描找出缺失的数字
    * ***********
    *方法二
    * 对给定数组进行求和，然后累加前n项，相减得到缺失的数字
    * ***********
    * 方法三
    * 利用位操作异或，相同的数异或值为 0
    * 不同的异或结果为 1
    * */
    public static void main(String[] args) {
        int[] iarr = {0, 1, 3};
        int n = 3;
        int x = 0;
        for (int i = 0; i <= n; i++) {
            x ^= i;
        }
        for (int i = 0; i < iarr.length; i++) {
            x ^= iarr[i];
        }
        System.out.println(x);
    }
}