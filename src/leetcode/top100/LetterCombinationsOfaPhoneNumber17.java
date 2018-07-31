package leetcode.top100;

import java.util.*;

/**
 * Created by qxiong on 2018/1/10.
 */
public class LetterCombinationsOfaPhoneNumber17 {
    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        for (String s : res) {
            System.out.println(s);
        }
    }

    static public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits == null || digits.length() == 0) return new LinkedList<>();
        List<String> res = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        if (map.containsKey(digits.charAt(0) - '0')) {
            String v = map.get(digits.charAt(0) - '0');
            for (int i = 0; i < v.length(); i++) {
                queue.add(v.charAt(i) + "");
            }
        }
        for (int i = 1, len = digits.length(); i < len; i++) {
            if (map.containsKey(digits.charAt(i) - '0')) {
                int s = queue.size();
                String v = map.get(digits.charAt(i) - '0');
                for (int j = 0; j < s; j++) {
                    String f = queue.poll();
                    for (int k = 0; k < v.length(); k++) {
                        queue.add(f + "" + v.charAt(k));
                    }
                }
            }
        }

        for (String ts : queue) {
//            System.out.println(ts);
            res.add(ts);
        }

        /*for (;!queue.isEmpty();) {
            System.out.println(queue.poll());
        }*/

//        System.out.println(queue.size());

        return res;
    }
}
