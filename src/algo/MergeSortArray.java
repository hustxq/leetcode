package algo;

/**
 * Created by sse on 2017/9/6.
 */
public class MergeSortArray {
    public static void main(String[] args) {
        int m=2,n=3;
        int[] arr=new int[m + n];
        arr[0]=1;arr[1]=10;
        int[] brr  = new int[n];
        brr[0]=3;brr[1]=5;brr[2]=7;
        int k = m+n-1;
        int i=m-1;
        int j=n-1;
        while (k>=0){
            if (i>=0 && j>=0){
                if (arr[i]>brr[j]){
                    arr[k--] = arr[i--];
                }else {
                    arr[k--] = brr[j--];
                }
            }else break;
        }
        if (i<0){
            while (k>=0) arr[k--]=brr[j--];
        }
        for (int l = 0, len=arr.length; l < len; l++) {
            System.out.println(arr[l]);
        }
    }
}
