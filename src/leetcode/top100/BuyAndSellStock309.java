package leetcode.top100;

/**
 * Created by qxiong on 2018/3/26 0026.
 */
public class BuyAndSellStock309 {
    static public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] plans = new int[n][3];
        plans[0][0] = prices[0];

        for (int i = 1; i < n; i++) {
            /*for (int j = 0; j < 3; j++) {

            }*/
//            buy
            plans[i][0] = prices[i];
            plans[i][1] = Math.max(plans[i-1][1],prices[i]-plans[i-1][0]);
        }
        return 0;
    }
}
