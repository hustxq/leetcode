package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/3/19 0019.
 */
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "af";
        String p = "be";
        List<Integer> res = findAnagrams(s, p);
        for (int i : res) {
            System.out.println(i);
        }
    }

    static public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = s.length(), e = p.length();
        if (r < e)
            return new ArrayList<>();
        int[] iarr = new int[26];
        int sum = 0;
        for (int i = 0; i < e; i++) {
            iarr[p.charAt(i) - 'a'] += 1;
        }
        int[] tarr = new int[26];
        for (int i = 0; i < e; i++) {
            tarr[s.charAt(i) - 'a'] += 1;
        }
        if (isSame(iarr, tarr)) {
            res.add(l);
        }
//        System.out.println("size:"+res.size());

        while (l < r - e) {
//            tmp += (s.charAt(l + e) - s.charAt(l));
            tarr[s.charAt(l + e) - 'a'] += 1;
            tarr[s.charAt(l) - 'a'] -= 1;
            if (isSame(iarr, tarr)) {
                res.add(l + 1);
            }
            l++;
        }
        return res;
    }

    static private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && b[i] != 0)
                System.out.println((char) (i + 'a') + ":" + a[i] + "," + b[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
