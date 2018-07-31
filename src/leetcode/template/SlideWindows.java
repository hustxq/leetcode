package leetcode.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qxiong on 2018/3/19 0019.
 */
public class SlideWindows {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        if (s.length() < t.length()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        int begin=0,end=0;
        int len = Integer.MAX_VALUE;
        while (end<s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if (map.get(c)==0) count--;
            }
            end++;
            while (count==0){
                char tc = s.charAt(begin);
                if (map.containsKey(tc)){
                    map.put(tc,map.get(tc)+1);
                    if (map.get(tc)>0)count++;
                }
                /* save/update target*/
                begin++;
            }
        }
        return res;
    }
}
