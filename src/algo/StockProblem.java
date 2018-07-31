package algo;

import java.util.Scanner;

/**
 * @Author hustxq.
 * @Date 2017/10/9 10:08
 */
public class StockProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
//        String[] sarr = scanner.nextLine().split(" ");
        int[] iarr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(scanner.nextLine());
            iarr[i] = calc(tmp);
        }
        for (int tmp:iarr){
            System.out.println(tmp);
        }
    }

    public static int calc(int m) {
        int sum = 1;
        int cnt = 1;
        int day = 1;
        if (m <= 1) {
            return 1;
        }else {
            while (day < m){
                for (int i = 0; i < cnt; i++) {
                    day++;
                    sum++;
                    if (day == m){
                        return sum;
                    }
                }
                cnt++;
//                跌一天
                day++;
                sum--;
            }
        }
        /*else if (m == 2) {
            return 2;
        } else {
            while (day < m) {
                day++;
                sum--;
                if (day < m) {
                    for (int i = 0; i < cnt; i++) {
                        sum++;
                        day++;
                        if (day == m) {
                            return sum;
                        }
                    }
                    cnt++;
                }
            }
        }*/
        return sum;
    }
}
