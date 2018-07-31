package algo;

/**
 * Created by sse on 2017/9/11.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] iarr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 23;
        int row = iarr.length;
        int col = iarr[0].length;
        int i=0;
        int j =col-1;
        while (i<row && j<col){
            if (iarr[i][j]<target){
                i++;
            }else if (iarr[i][j]>target){
                j--;
            }else {
                System.out.println(i+","+j);
                break;
            }
        }
        show(iarr[0]);
    }

    public static void show(int... iarr){
        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }
}
