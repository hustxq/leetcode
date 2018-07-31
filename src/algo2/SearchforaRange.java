package algo2;

/**
 * Created by sse on 2017/9/12.
 */
public class SearchforaRange {
    public static void main(String[] args) {
        binarySearch();
    }

    public static void calc(){
        int[] iarr = {5, 6, 7, 8, 10};
        int target = 7;
        int start = 0;
        int end = iarr.length - 1;
//        第一次 二分查找 找第一个位置
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (iarr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int s = -1, e = -1;
        if (start < iarr.length && iarr[start] == target) {
            s = start;
            end = iarr.length - 1;
        } else {
            System.out.println(String.format("[%d, %d]", s, e));
            return;
        }
        while (start <= end) {
            int mid = (start + end + 1) >> 1;
            if (iarr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(String.format("[%d, %d]", s, end));
    }

    public static void binarySearch(){
        int[] iarr = {5, 6, 7, 8, 10};
        int target = 10;
        int s = 0, e = iarr.length-1;
        while (s<=e){
            int mid = (s+e)>>1;
            if (iarr[mid]>target){
                e = mid-1;
            }else if (iarr[mid]<target){
                s = mid +1;
            }else {
                System.out.println("find:"+mid);
                return;
            }
        }
        System.out.println("not found");
    }
}
