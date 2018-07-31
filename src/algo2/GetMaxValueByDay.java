package algo2;

/**
 * @Author hustxq.
 * @Date 2017/10/9 10:45
 */
public class GetMaxValueByDay {
    public static void main(String[] args) {
        int[] iarr=new int[]{2,1,5,3,1};
        System.out.println(getValue(iarr,0,iarr.length-1,1));
    }
    static int getValue(int[] iarr,int s,int e,int p){
        if (s == e){
            return iarr[s]*p;
        }else {
            int v1 = iarr[s]*p+getValue(iarr,s+1,e,p+1);
            int v2 = iarr[e]*p+getValue(iarr,s,e-1,p+1);
            return Math.max(v1,v2);
        }
    }
}