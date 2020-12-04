package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class IsPossible659 {

    static public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            //当前元素个数
            int count = countMap.getOrDefault(num, 0);
            if (count > 0) {
                int preEndCount = endMap.getOrDefault(num - 1, 0);
                if (preEndCount > 0) {
                    countMap.put(num, count - 1);
                    endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                    endMap.put(num - 1, preEndCount - 1);
                } else {
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(num, count - 1);
                        countMap.put(num + 1, count1 - 1);
                        countMap.put(num + 2, count2 - 1);
                        endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
