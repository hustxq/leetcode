package algo;

/**
 * Created by sse on 2017/9/6.
 * <p>
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {

    public static void main(String[] args) {
//        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aa", "*"));
    }

    public static boolean isMatch(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        boolean[][] res = new boolean[pLen + 1][sLen + 1];
        res[0][0] = true;
        for (int i = 0; i < sLen; i++) {
            res[0][i + 1] = false;
        }
        for (int i = 0; i < pLen; i++) {
            if (res[i][0] == true && p.charAt(pLen - i - 1) == '*')
                res[i + 1][0] = true;
            else res[i + 1][0] = false;
        }
        for (int i = 1; i < pLen + 1; i++) {
            for (int j = 1; j < sLen + 1; j++) {
                if (p.charAt(pLen - i) == '*') {
                    res[i][j] = res[i - 1][j] == true ? true : res[i][j - 1];
                } else if (p.charAt(pLen - i) == '?' || p.charAt(pLen - i) == s.charAt(sLen - j)) {
                    res[i][j] = res[i - 1][j - 1];
                }else {
                    res[i][j] =false;
                }
            }
        }
        return res[pLen][sLen];
    }
}
