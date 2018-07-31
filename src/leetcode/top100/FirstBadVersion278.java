package leetcode.top100;

/**
 * Created by qxiong on 2018/1/17 0017.
 */
public class FirstBadVersion278 {
    public static void main(String[] args) {

    }

    static public int firstBadVersion(int n) {
        int s = 1, e = n, c = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
//            isBadVersion.
            if (mid > 0) {
                c = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return c;
    }
}
