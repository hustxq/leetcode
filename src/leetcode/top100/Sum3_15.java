package leetcode.top100;

import java.util.*;

/**
 * Created by qxiong on 2018/1/10.
 */
public class Sum3_15 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};//{-1, 0, 1, 2, -1, -4};
        //{0,0,0,0};//
        List<List<Integer>> l = threeSum2(nums);
        for (List<Integer> list : l) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = len - 1, sum = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        /*for (int i : nums) {
            System.out.println(i);
        }*/
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                /*for (int k = j+1; k < len; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        String s = nums[i]+","+nums[j]+","+nums[k];
                        if (!set.contains(s)) {
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[i]);
                            t.add(nums[j]);
                            t.add(nums[k]);
                            res.add(t);
                            set.add(s);
                        }
                        break;
                    }
                }*/
                int k = -(nums[i] + nums[j]);
                if (map.containsKey(k) && map.get(k) > j) {
//                    System.out.println(nums[i]+","+nums[j]+","+k);
                    String s = nums[i] + "," + nums[j] + "," + k;
                    if (!set.contains(s)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(k);
                        res.add(t);
                        set.add(s);
                    }
                    break;
                }
            }
        }
        return res;
    }
}
