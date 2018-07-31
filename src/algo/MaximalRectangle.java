package algo;

/**
 * Created by sse on 2017/9/9.
 *
 * 遇到 0 则为 0， 遇到 1 则为 高度累加
 *
 * 每行构造成一个直方图求矩形最大面积
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        int[][] iarr = {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 0}
        };
        int[] tarr=new int[iarr.length];
        int area = 0;
        for (int i = 0,len=iarr.length; i < len; i++) {
            for (int j = 0; j < iarr[0].length; j++) {
                if (iarr[i][j]==0){
                    tarr[j]=0;
                }else {
                    tarr[j]+=1;
                }
            }
            area = Math.max(area,LargestRect.calcLargest(tarr));
        }
        System.out.println(area);
    }
}
