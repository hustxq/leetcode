package algo2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sse on 2017/9/6.
 */
public class SumFindIndices {
    public static void main(String[] args) {
        int[] iarr = {1,2, 7, 11, 15,8};
        int target = 9;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < iarr.length; i++) {
            map.put(iarr[i],i);
        }
        for (int i = 0; i < iarr.length; i++) {
            int tmp = target - iarr[i];
            if (map.containsKey(tmp)){
                System.out.println(String.format("index1=%d, index2=%d",i+1,map.get(tmp)+1));
                return;
            }
        }
    }
}
