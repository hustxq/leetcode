package leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qxiong on 2018/1/25 0025.
 */
public class EditDistance72 {
    public static void main(String[] args) {
        System.out.println(minDistance("intention",
                "execution"));
    }

    /**
     * 改进
     *
     * @param word1
     * @param word2
     * @return
     */
    static public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] vals = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            vals[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            vals[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = word1.charAt(i - 1);
                if (ch == word2.charAt(j - 1)) {
                    vals[i][j] = vals[i - 1][j - 1];
                } else {
//                    replace
                    vals[i][j] = Math.min(vals[i - 1][j - 1] + 1
//                            insertion
                            , Math.min(vals[i][j - 1] + 1
//                                    deletion
                                    , vals[i - 1][j] + 1));
                }
            }
        }
        return vals[m][n];
    }

    /**
     * @param word1
     * @param word2
     * @return
     */
    static public int minDistance(String word1, String word2) {
        return Math.min(calc(word1, word2), calc(word2, word1));
    }

    static private int calc(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        /*if (m<n){
            String s = word1;
            word1 = word2;
            word2 = s;
            int i = m;
            m = n;
            n = i;
        }*/
        int[][] vals = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            vals[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            vals[0][i] = 0;
        }
        int[] iarr1 = new int[m];
        int[] iarr2 = new int[n];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = word1.charAt(i - 1);
                if (ch == word2.charAt(j - 1)) {
                    vals[i][j] = vals[i - 1][j - 1] + 1;
                    if (!map1.containsKey(vals[i][j])) {
                        map1.put(vals[i][j], i - 1);
                        map2.put(vals[i][j], j - 1);
                    }
                } else {
                    vals[i][j] = Math.max(vals[i - 1][j], vals[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals[0].length; j++) {
                System.out.print(vals[i][j] + "\t");
            }
            System.out.println();
        }
        int len = vals[m][n];
        int p1 = -1, p2 = -1;
        int sum = 0;
        System.out.println(len);
        for (int i = 1; i <= len; i++) {
            int i1 = map1.get(i);
            int i2 = map2.get(i);
            System.out.println(i1 + "," + i2);
            sum += (Math.max((i1 - p1), (i2 - p2)) - 1);
            p1 = i1;
            p2 = i2;
            System.out.println("sum:" + sum);
        }
        sum += Math.max((m - 1 - p1), (n - 1 - p2));
        System.out.println("sum:" + sum);
        return sum;
    }
}
