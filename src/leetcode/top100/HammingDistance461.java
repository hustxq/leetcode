package leetcode.top100;

/**
 * Created by qxiong on 2018/4/2 0002.
 */
public class HammingDistance461 {
    static public int hammingDistance(int x, int y) {
        x = x^y;
        return Integer.bitCount(x);
    }

    public static void main(String[] args) {
//        System.out.println(Integer.bitCount(8));
        System.out.println(hammingDistance(2,4));
    }
}
