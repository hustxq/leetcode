package algo2;

/**
 * Created by sse on 2017/9/13.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] iarr = {1,3,5,6};
        int target = 0;
        int s = 0;
        int e = iarr.length - 1;
        while (s <= e) {
            int mid = (s + e) >> 1;
            if (iarr[mid]>target){
                e = mid-1;
            }else if (iarr[mid]<target){
                s = mid+1;
            }else {
                System.out.println(mid);
                return;
            }
        }
        System.out.println(s);
    }
}
