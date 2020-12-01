package leetcode.string;

import java.util.Arrays;

public class ReorganizeString767 {

    public static void main(String[] args) {
        String s = "vvvlo";
        System.out.println(reorganizeString(s));
    }

    static public String reorganizeString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        int[] arr = new int[26];

        int length = S.length();
        for (int i = 0; i < length; i++) {
            arr[S.charAt(i) - 'a']++;
        }
        int[][] res = new int[26][2];
        for (int i = 0; i < 26; i++) {
            res[i][0] = i;
            res[i][1] = arr[i];
        }

        Arrays.sort(res, (e1, e2) -> {
            return e2[1] - e1[1];
        });

        char[] carr = new char[length];
        int p = 0;
        for (int i = 0; i < length; i += 2) {
            if (res[p][1] > 0) {
                carr[i] = (char) (res[p][0] + 'a');
                res[p][1]--;
            } else {
                p++;
                i -=2;
            }
        }
        for (int i = 1; i < length; i += 2) {
            if (res[p][1] > 0) {
                carr[i] = (char) (res[p][0] + 'a');
                res[p][1]--;
            } else {
                p++;
                i -=2;
            }
        }

        return check(new String(carr));
    }

    static private String check(String s) {
//        System.out.println(s);
        for (int i = 0, len = s.length(); i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return "";
            }
        }
        return s;
    }
}
