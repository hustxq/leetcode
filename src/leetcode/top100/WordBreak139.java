package leetcode.top100;

import java.util.List;
import java.util.*;

/**
 * Created by qxiong on 2018/3/9 0009.
 */
public class WordBreak139 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = //new ArrayList<>();
                Arrays.asList("cat", "cats", "and", "sand", "dog");
        /*wordDict.add("leet");
        wordDict.add("code");*/
        System.out.println(wordBreak(s, wordDict));
    }

    static public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        boolean[] vals = new boolean[s.length() + 1];
        vals[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (vals[j] && set.contains(s.substring(j, i))) {
                    vals[i] = true;
                    break;
                }
            }
        }

        int l = 0;
        for (int i = 1; i < vals.length; i++) {
            if (vals[i]) {
                System.out.println(s.substring(l, i));
                l = i;
            }
        }
        return true;
    }

    static public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        boolean[] vals = new boolean[s.length() + 1];
        vals[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (vals[j] && set.contains(s.substring(j, i))) {
                    vals[i] = true;
                    break;
                }
            }
        }

        int l = 0;
        for (int i = 1; i < vals.length; i++) {
            if (vals[i]) {
                System.out.println(s.substring(l, i));
                l = i;
            }
        }
        return vals[s.length()];
    }

    static private boolean wb(String s, int p, Set<String> set) {
        if (p == s.length()) return false;

        return true;
    }
}
