package leetcode.top100;

import java.util.*;

/**
 * Created by xq on 2018/1/20.
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        for (List<String> l:res){
            for (String s:l){
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] carr;
        for (int i = 0, len = strs.length; i < len; i++) {
            String s = strs[i];
            carr = new int[26];
            for (int j = 0, slen = s.length(); j < slen; j++) {
                carr[s.charAt(j) - 'a'] = 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (carr[j] == 1)
                    sb.append((char) (j + 'a') + "");
            }
//            System.out.println(sb.toString());
            String ts = sb.toString();
            if (map.containsKey(ts)){
                List<String> list = map.get(ts);
                list.add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(ts,list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String k = (String) iterator.next();
            res.add(map.get(k));
        }
        return res;
    }
}
