package leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qxiong on 2018/1/16.
 */
public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        int[] tarr = new int[3];
        permuteUnique(res, nums, vis, tarr, 0);
        return res;
    }

    static public void permuteUnique(List<List<Integer>> res, int[] nums, boolean[] vis, int[] tarr, int p) {
//        find
        if (tarr.length == p) {
            List<Integer> t = new ArrayList<>();//Arrays.asList(tarr);
            for (int i : tarr) {
                t.add(i);
            }
            res.add(t);
        } else {
            for (int i = 0, len = nums.length; i < len; i++) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
                tarr[p] = nums[i];
                vis[i] = true;
                permuteUnique(res, nums, vis, tarr, p + 1);
                vis[i] = false;
            }
        }
    }

    /**
     * 不包含重复元素的排列
     *
     * @param nums
     * @return
     */
    static public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        int[] tarr = new int[2];
        Arrays.sort(nums);
        permuteAll(res, nums, vis, tarr, 0);
        return res;
    }

    static public void permuteAll(List<List<Integer>> res, int[] nums, boolean[] vis, int[] tarr, int p) {
//        find
        if (tarr.length == p) {
            List<Integer> t = new ArrayList<>();//Arrays.asList(tarr);
            for (int i : tarr) {
                t.add(i);
            }
            res.add(t);
        } else {
            for (int i = 0, len = nums.length; i < len; i++) {
                if (!vis[i]) {
                    tarr[p] = nums[i];
                    vis[i] = true;
                    permuteAll(res, nums, vis, tarr, p + 1);
                    vis[i] = false;
                }
            }
        }
    }
}
