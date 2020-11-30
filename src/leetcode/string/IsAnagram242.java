package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram242 {

    static public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        int sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        int tLen = t.length();

        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                Integer cnt = map.get(c);
                cnt--;
                if (cnt < 0) {
                    return false;
                }
                map.put(c, cnt);
            }
        }

        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
