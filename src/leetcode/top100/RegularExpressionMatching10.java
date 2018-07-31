package leetcode.top100;

/**
 * Created by qxiong on 2018/1/8.
 */
public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa", "a*"));
    }
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
        } else {
            return first && isMatch(s.substring(1), p.substring(1));
        }
    }
}
