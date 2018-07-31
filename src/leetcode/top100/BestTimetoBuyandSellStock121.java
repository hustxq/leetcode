package leetcode.top100;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by qxiong on 2018/2/1 0001.
 */
public class BestTimetoBuyandSellStock121 {
    public static void main(String[] args) {
        System.out.println(maxProfitAcc(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    static public int maxProfitAcc(int[] prices) {
        int maxCur = 0, max = 0;
        for (int i = 0, len = prices.length - 1; i < len; i++) {
            maxCur = Math.max(0, maxCur += prices[i + 1] - prices[i]);
            max = Math.max(max, maxCur);
        }
        return max;
    }

    static public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
//        min list
        int len = prices.length;
        List<Integer> minPoints = new ArrayList<>();
        minPoints.add(0);
        for (int i = 1; i < prices.length - 1; i++) {
            if ((prices[i - 1] >= prices[i] && prices[i] < prices[i + 1])
                    || prices[i - 1] > prices[i] && prices[i] <= prices[i + 1]) {
                minPoints.add(i);
            }
        }
//        if (prices[len-1] < prices[minPoints.get(minPoints.size()-1)])
        {
            minPoints.add(len - 1);
        }

        showList(minPoints);
//        max list
        List<Integer> maxPoints = new ArrayList<>();
        maxPoints.add(0);
        for (int i = 1; i < prices.length - 1; i++) {
            if ((prices[i - 1] <= prices[i] && prices[i] > prices[i + 1])
                    || (prices[i - 1] < prices[i] && prices[i] >= prices[i + 1])) {
                maxPoints.add(i);
            }
        }
//        if (prices[len-1] > prices[maxPoints.get(maxPoints.size()-1)])
        {
            maxPoints.add(len - 1);
        }

        showList(maxPoints);

        int max = 0;
        for (int i = 0; i < minPoints.size(); i++) {
            for (int j = 0; j < maxPoints.size(); j++) {
                if (minPoints.get(i) < maxPoints.get(j)) {
                    int t = prices[maxPoints.get(j)] - prices[minPoints.get(i)];
                    if (max < t) {
                        max = t;
                    }
                }
            }
        }
        return max;
    }

    private static void showList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    static public int maxProfit2(int[] prices) {
        int l = 0, r = prices.length - 1;
        int max = 0;
        /*while (l < r){
            int t = prices[r] - prices[l];
            if (max<t){
                max = t;
                l++;
            }
        }*/
        int min = prices[0];
        for (int i = 1; i < r; i++) {
            if (prices[i] < prices[i - 1]) {
                if (min > prices[i]) {
                    min = prices[i];
                }
            }
        }
        return 0;
    }

    /**
     * @param prices
     * @return
     */
    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int t = prices[j] - prices[i];
                if (max < t) {
                    max = t;
                }
            }
        }
        return max;
    }
}
