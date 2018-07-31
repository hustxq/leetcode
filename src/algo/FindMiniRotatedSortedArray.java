package algo;

/**
 * Created by sse on 2017/9/7.
 */
public class FindMiniRotatedSortedArray {
    public static int find(int[] iarr){
        int len = iarr.length;
        if (len==0)return -1;
        if (len==1)return iarr[0];
        if (len==2)return iarr[0]>iarr[1]?iarr[1]:iarr[0];
        int s=0,e=len-1;
        while (s<e-1){
            if (iarr[s]<iarr[e]){
                return iarr[s];
            }
            int mid=(s+e)/2;
            if (iarr[mid]>iarr[s]){
                s=mid;
            }else if (iarr[mid]<iarr[s]){
                e=mid;
            }
        }
        return iarr[s]>iarr[e]?iarr[e]:iarr[s];
    }
    public static void main(String[] args) {
        int[] iarr={7,1,2,3,4,6};
        System.out.println(find(iarr));
    }
}
