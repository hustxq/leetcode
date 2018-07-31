package algo2;

/**
 * Created by sse on 2017/9/14.
 */
public class Numberof1Bits {
    public static void main(String[] args) {
        int tar = 15;
        System.out.print(tar+"二进制数中1的个数为:");
        int count =0;
        while (tar>0){
            int t = tar & 1;
            if (t==1) count++;
            tar = tar >> 1;
        }
        System.out.println(count);
    }
}
