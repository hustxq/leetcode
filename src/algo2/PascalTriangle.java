package algo2;

/**
 * Created by sse on 2017/9/5.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int index = 10;
        int[][] iarr= new int[index][index];
        for (int i = 0; i <index; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0||j==index-1){
                    iarr[i][j]=1;
                }else {
                    iarr[i][j]=iarr[i-1][j-1]+iarr[i-1][j];
                }
            }
        }
        for (int[] t:iarr){
            for (int i:t){
                if (i==0) break;
                System.out.print(i+" ");
            }
            System.out.println();
        }
//        直接求第i行的数列
        int[] jarr=new int[index];
        for (int i = 0; i < jarr.length; i++) {
            jarr[i] = 1;
        }
        for (int i = 0; i < jarr.length; i++) {
            for (int j = i-1; j > 0; j--) {
                jarr[j]=jarr[j]+jarr[j-1];
            }
        }
        for (int i = 0; i < jarr.length; i++) {
            System.out.print(jarr[i]+" ");
        }
    }
}
