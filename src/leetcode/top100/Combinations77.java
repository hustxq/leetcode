package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qxiong on 2018/1/16.
 */
public class Combinations77 {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(3, 4);
        for (List<Integer> i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> combine(int n, int k) {
        if (k < 1 || n < k) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        boolean[] vis = new boolean[n];
        int[] tarr = new int[k];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        com(res, nums, vis, tarr, 0, 0);
        return res;
    }

    private static void com(List<List<Integer>> res, int[] nums, boolean[] vis, int[] tarr, int p, int j) {
        if (tarr.length == p) {
            List<Integer> t = new ArrayList<Integer>();
            for (int i : tarr) t.add(i);
            res.add(t);
        } else {
            for (; j < nums.length; j++) {
                if (!vis[j]) {
                    tarr[p] = nums[j];
                    vis[j] = true;
                    com(res, nums, vis, tarr, p + 1, j);
                    vis[j] = false;
                }
            }
        }
    }
}
