package leetcode.array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    public static void main(String[] args) {

        System.out.println(calc("eat"));
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String s = calc(str);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private static String calc(String s) {
        int[] arr = primesArr();
        BigDecimal b = BigDecimal.ONE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            b = b.multiply(new BigDecimal(arr[c - 'a']));
        }
        return b.toPlainString();
    }

    static public int[] primesArr() {
        int n = 150;
        int[] res = new int[26];
        int[] arr = new int[n];
        int p = 0;

        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = 2 * i; j < n; j += i) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                    }
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (arr[i] == 0 && p < 26) {
                res[p++] = i;
            }
        }

        return res;
    }
}
