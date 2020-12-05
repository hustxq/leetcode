package lcp;

import java.util.Arrays;

public class BreakfastNumber18 {

    public static void main(String[] args) {
        int[] staple = {10, 20, 5};
        int[] drinks = {5, 5, 2};
        int x = 15;
        System.out.println(breakfastNumber(staple, drinks, x));
    }

    static public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int j = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            for (; j >= 0; j--) {
                if (staple[i] + drinks[j] <= x) {
                    ans = (ans + j + 1) % 1000000007;
                    break;
                }
            }
        }
        return ans;
    }
}
