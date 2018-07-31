package leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxiong on 2018/1/16.
 */
public class PermutationSequence60 {
    public static void main(String[] args) {
        System.out.print(getPermutation(3, 2));
    }

    static public String getPermutation(int n, int k) {
        if (k < 1 || n < k) return null;
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        boolean[] vis = new boolean[n];
        int[] tarr = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        permute(res, nums, vis, tarr, 0, k);
        /*StringBuilder sb = new StringBuilder();
        for (List<Integer> i:res){
            StringBuilder tsb = new StringBuilder();
            for (int j:i){
                tsb.append(j+"");
            }
            sb.append(tsb.toString()+"\n");
        }
        String s = sb.toString();
        s.substring(0,s.length()-1)*/
        StringBuilder sb = new StringBuilder();
        for (int i : res.get(k - 1)) {
            sb.append(i + "");
        }
        return sb.toString();
    }

    static int start = 1;

    private static void permute(List<List<Integer>> res, int[] nums, boolean[] vis, int[] tarr, int p, int k) {
        if (tarr.length == p) {
            if (start == k) {
                List<Integer> t = new ArrayList<>();//Arrays.asList(tarr);
                for (int i : tarr) {
                    t.add(i);
                }
                res.add(t);
            }
        } else {
            for (int i = 0, len = nums.length; i < len; i++) {
                if (!vis[i]) {
                    tarr[p] = nums[i];
                    vis[i] = true;
                    permute(res, nums, vis, tarr, p + 1, k);
                    vis[i] = false;
                }
            }
        }
    }
}
