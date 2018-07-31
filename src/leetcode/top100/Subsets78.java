package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qxiong on 2018/1/24 0024.
 */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null) {
            return res;
        }
        if (nums.length == 1) {
            List<Integer> t = new ArrayList<>();
            t.add(nums[0]);
            res.add(t);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean[] vis = new boolean[nums.length];
            int[] iarr = new int[(i + 1)];
            pl(res, nums, vis, iarr, 0, 0);
        }
        return res;
    }

    static private void pl(List<List<Integer>> res, int[] nums, boolean[] vis, int[] iarr, int p, int i) {
        if (iarr.length == p) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < iarr.length; j++) {
                t.add(iarr[j]);
            }
            res.add(t);
        } else {
            for (; i < nums.length; i++) {
                if (vis[i]) continue;
                vis[i] = true;
                iarr[p] = nums[i];
                pl(res, nums, vis, iarr, p + 1, i);
                vis[i] = false;
            }
        }
    }
}
