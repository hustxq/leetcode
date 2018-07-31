package leetcode.top100;

import java.util.*;

/**
 * Created by qxiong on 2018/1/16.
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 21;
        List<List<Integer>> res = combinationSum(candidates, target);
        /*System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }*/
        for (List<Integer> i : res) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length ==0 || target<0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        com(set, res, new ArrayList<>(), candidates, target);
        return res;
    }

    static public void com(Set<String> set, List<List<Integer>> res, List<Integer> tmpres, int[] candidates, int target) {
        if (target < 0) return;
        else if (target == 0) {
            List<Integer> t = new ArrayList<>();
            for (int i:tmpres){
//                System.out.print(i+" ");
                t.add(i);
            }
//            System.out.println(res.size());
            Collections.sort(t);
            StringBuilder sb = new StringBuilder();
            for (int i:t){
                sb.append(i+"");
            }
            if (!set.contains(sb.toString())) {
                res.add(new ArrayList<>(tmpres));
                set.add(sb.toString());
            }
        } else {
            for (int i = 0, len = candidates.length; i < len; i++) {
                tmpres.add(candidates[i]);
                com(set, res, tmpres, candidates, target - candidates[i]);
                tmpres.remove(tmpres.size() - 1);
            }
        }
    }
}
