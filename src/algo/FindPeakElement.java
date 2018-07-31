package algo;

/**
 * Created by sse on 2017/9/13.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] iarr = {11, 1, 2, 3, 5, 10};
        int s = 0;
        int e = iarr.length - 1;
        int len = iarr.length;
        if (iarr.length == 1) {
            System.out.println(iarr[0]);
            return;
        }
        int mid = 0;
        while (s <= e) {
            mid = (s + e) >> 1;
            if ((mid == 0 || iarr[mid] > iarr[mid - 1]) &&
                    (mid == len - 1 || iarr[mid] > iarr[mid + 1])) {
                System.out.println(mid);
                return;
            } else if (mid > 0 && iarr[mid - 1] > iarr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(mid);
    }
}
