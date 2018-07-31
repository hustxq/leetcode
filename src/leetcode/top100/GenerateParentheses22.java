package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/12.
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(2);
        for (String s : res) {
            System.out.println(s);
        }
    }

    static public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    static public void backtrack(List<String> list, String s, int open, int close, int p) {
        if (s.length() == p * 2) {
            list.add(s);
            return;
        }
        if (open < p) {
            backtrack(list, s + "(", open + 1, close, p);
        }
        if (close < open) {
            backtrack(list, s + ")", open, close + 1, p);
        }
    }
}
